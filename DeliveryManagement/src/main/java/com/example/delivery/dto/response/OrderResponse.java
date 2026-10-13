package com.example.delivery.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	private Long orderId;
	private Long userId;
	private String userName;
	private Double totalPrice;
	private String status;
	private LocalDateTime orderDate;
	private List<OrderItemResponse> orderItems;
}
