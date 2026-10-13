package com.example.delivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.delivery.dto.response.OrderResponse;



@FeignClient(name = "PRODUCTMANAGEMENT")
public interface OrderClient {
	
	@GetMapping("order/getorderbyid/{id}")
	public OrderResponse getOrderById(@PathVariable Long id);
}
