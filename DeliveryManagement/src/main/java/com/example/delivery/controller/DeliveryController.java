package com.example.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dto.request.DeliveryCreateRequest;
import com.example.delivery.dto.response.DeliveryResponse;
import com.example.delivery.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	DeliveryService _service;
	
	@PostMapping
	public DeliveryResponse assignDelivery(@RequestBody DeliveryCreateRequest req) {
		return _service.assignDelivery(req);
	}
	
	@GetMapping("/{id}")
	public DeliveryResponse findByDeliveryId(@PathVariable Long id) {
		return _service.findByDeliveryId(id);
	}
}
