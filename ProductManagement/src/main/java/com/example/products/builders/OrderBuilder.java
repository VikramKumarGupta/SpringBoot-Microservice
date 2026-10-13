package com.example.products.builders;

import java.time.LocalDateTime;

import com.example.products.dto.request.OrderCreateRequest;
import com.example.products.dto.request.OrderUpdateRequest;
import com.example.products.dto.response.OrderResponse;
import com.example.products.model.Order;

public class OrderBuilder {

	public static Order buildOrderFromOrderCreaterequest(OrderCreateRequest request) {
		return Order.builder()
					.userId(request.getUserId())
					.status(request.getStatus())
					.orderDate(LocalDateTime.now())
					.orderItems(OrderItemBuilder.buildOrderItemFromOrderItemCreateRequest(request.getOrdeItems()))
					.build();
	}
	
	public static OrderResponse buildOrderResponseFromOrder(Order order) {
		return OrderResponse.builder()
					.orderId(order.getOrderId())
					.userId(order.getUserId())
					.totalPrice(order.getTotalPrice())
					.status(order.getStatus())
					.orderDate(LocalDateTime.now())
					.orderItems(OrderItemBuilder.buildOrderItemResponseFromOrderItem(order.getOrderItems()))
					.build();
	}
	public static Order buildOrderFromOrderUpdateRequest(Order existingOrder,OrderUpdateRequest request) {

	    return Order.builder()
	    		.orderId(existingOrder.getOrderId())
	            .userId(request.getUserId())
	            .status(request.getStatus())
	            .orderDate(LocalDateTime.now())
	            .orderItems(
	                    OrderItemBuilder.buildOrderItemFromOrderItemUpdateRequest(
	                            request.getOrdeItems()
	                    )
	            )
	            .build();
	}
}
