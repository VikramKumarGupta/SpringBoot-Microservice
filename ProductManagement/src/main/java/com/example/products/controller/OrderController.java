package com.example.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.dto.request.OrderCreateRequest;
import com.example.products.dto.request.OrderUpdateRequest;
import com.example.products.dto.request.ProductCreateRequest;
import com.example.products.dto.request.ProductUpdateRequest;
import com.example.products.dto.response.OrderResponse;
import com.example.products.dto.response.ProductResponse;
import com.example.products.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderService _service;
	
	@PostMapping("/saveorder")
	public OrderResponse saveOrder(@RequestBody OrderCreateRequest request) {
		return  _service.saveOrder(request);
	}
	
	@GetMapping("/getallorders")
	public List<OrderResponse> getAllOrders(){
		return _service.getAllOrders();
	}
	
	@GetMapping("/getorderbyid/{id}")
	public OrderResponse getOrderById(@PathVariable Long id) {
		return _service.getOrderById(id);
	}
	
	@PutMapping("/updateorder/{id}")
	public OrderResponse updateOrder(@PathVariable Long id,@RequestBody OrderUpdateRequest request) {
		return _service.updateProduct(id,request);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public void deleteOrder(@PathVariable Long id) {
		_service.deleteOrder(id);
	}
}
