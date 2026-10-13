package com.example.products.builders;

import java.util.List;

import com.example.products.dto.request.OrderItemCreateRequest;
import com.example.products.dto.request.OrderItemUpdateRequest;
import com.example.products.dto.request.OrderUpdateRequest;
import com.example.products.dto.response.OrderItemResponse;
import com.example.products.model.OrderItem;

public class OrderItemBuilder {

	public static List<OrderItem> buildOrderItemFromOrderItemCreateRequest(List<OrderItemCreateRequest> request) {
				return request.stream()
		                .map(req -> OrderItem.builder()
		                        .productId(req.getProductId())
		                        .quantity(req.getQuantity())
		                        .price(req.getPrice())
		                        .build())
		                .toList();
	}
	
	public static List<OrderItem> buildOrderItemFromOrderItemUpdateRequest(List<OrderItemUpdateRequest> request) {
		return request.stream()
                .map(req -> OrderItem.builder()
                		.productId(req.getProductId())
                		.quantity(req.getQuantity())
                        .price(req.getPrice())
                        .build())
                .toList();
}
	public static List<OrderItemResponse> buildOrderItemResponseFromOrderItem(List<OrderItem> request) {
		return request.stream()
                .map(req -> OrderItemResponse.builder()
                		.productId(req.getProductId())
                		.quantity(req.getQuantity())
                        .price(req.getPrice())
                        .build())
                .toList();
}
}
