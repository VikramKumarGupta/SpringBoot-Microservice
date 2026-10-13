package com.example.products.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.products.builders.OrderBuilder;
import com.example.products.dto.request.DeliveryCreateRequest;
import com.example.products.dto.request.OrderCreateRequest;
import com.example.products.dto.request.OrderUpdateRequest;
import com.example.products.dto.response.DeliveryResponse;
import com.example.products.dto.response.OrderResponse;
import com.example.products.dto.response.UserResponse;
import com.example.products.exceptions.OrderNotFoundException;
import com.example.products.model.Order;
import com.example.products.repoistory.OrderRepoistory;

@Service
public class OrderService {
	
	@Autowired
	OrderRepoistory _repo;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderResponse saveOrder(OrderCreateRequest request) {
		Order order = OrderBuilder.buildOrderFromOrderCreaterequest(request);
		Order save = _repo.save(order);
		String trackingno = UUID.randomUUID().toString();
		
		DeliveryCreateRequest deliveryCreateRequest = DeliveryCreateRequest.builder()
			.orderId(save.getOrderId())
			.shippingAddress("hyderabad")
			.estimatedDeliveryDate(LocalDate.of(2026, 07, 10))
			.status("placed")
			.trackingNumber(trackingno)
			.build();
		@Nullable
		DeliveryResponse deliveryResponse = restTemplate.postForObject("http://localhost:8084/delivery", 
				deliveryCreateRequest,DeliveryResponse.class);
		return OrderBuilder.buildOrderResponseFromOrder(save);
	}
	
	public List<OrderResponse> getAllOrders() {
		List<Order> allOrders = _repo.findAll();
		
		List<OrderResponse> list = allOrders.stream()
			.map(OrderBuilder::buildOrderResponseFromOrder)
			.toList();
		
		return list;
	}

	public OrderResponse getOrderById(Long id) {
		Order order = _repo.findById(id)
			.orElseThrow(()->new OrderNotFoundException("Order not found"));
		
		OrderResponse orderResponseFromOrder = OrderBuilder.buildOrderResponseFromOrder(order);
		
		UserResponse userResponse = restTemplate.getForObject("http://UserManagement/users/getuserbyid/"+order.getUserId(),UserResponse.class);
		orderResponseFromOrder.setUserName(userResponse.getUserName());
		
		return orderResponseFromOrder;
	}

	public OrderResponse updateProduct(Long id, OrderUpdateRequest request) {
		Order exisitngOrder = _repo.findById(id)
			.orElseThrow(()->new OrderNotFoundException("Order Not Found"));
		
		Order updateRequest = OrderBuilder.buildOrderFromOrderUpdateRequest(exisitngOrder, request);
		updateRequest = _repo.save(updateRequest);
		return OrderBuilder.buildOrderResponseFromOrder(updateRequest);
	}

	public void deleteOrder(Long id) {
		if(!_repo.existsById(id)) {
			throw new OrderNotFoundException("Order Not Existed");
		}
		_repo.deleteById(id);
	}
}
