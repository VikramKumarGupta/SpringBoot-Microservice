package com.example.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.delivery.builder.DeliveryBuilder;
import com.example.delivery.client.OrderClient;
import com.example.delivery.dto.request.DeliveryCreateRequest;
import com.example.delivery.dto.response.DeliveryResponse;
import com.example.delivery.dto.response.OrderResponse;
import com.example.delivery.model.Delivery;
import com.example.delivery.repoistory.DeliveryRepoistory;

@Service
public class DeliveryService {

	@Autowired
	DeliveryRepoistory _repo;
	
	@Autowired
	OrderClient client;
	
	public DeliveryResponse assignDelivery(DeliveryCreateRequest req) {
		Delivery delivery = DeliveryBuilder.buildDeliverFromDeliveryCreateRequest(req);
		Delivery save = _repo.save(delivery);
		DeliveryResponse response = DeliveryBuilder.buildDeliveryresponseFromDelivery(save);
		return response;
	}

	public DeliveryResponse findByDeliveryId(Long id) {
		Delivery delivery = _repo.findById(id)
			.orElseThrow(()->new RuntimeException("Delivery not Found"));
		
		 DeliveryResponse deliveryresponseFromDelivery = DeliveryBuilder.buildDeliveryresponseFromDelivery(delivery);
		 OrderResponse orderById = client.getOrderById(deliveryresponseFromDelivery.getOrderId());
		 
		 deliveryresponseFromDelivery.setTotalPrice(orderById.getTotalPrice());
		 return deliveryresponseFromDelivery;
		 
	}

}
