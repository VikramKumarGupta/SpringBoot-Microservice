package com.example.products.dto.response;

import com.example.products.model.Order;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
	private Long orderItemId;
	private Order order;
	private Long productId;
	private Integer quantity;
	private Double price;
}
