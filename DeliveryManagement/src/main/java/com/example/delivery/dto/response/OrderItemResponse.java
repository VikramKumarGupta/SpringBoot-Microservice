package com.example.delivery.dto.response;


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
	private com.example.delivery.model.Order order;
	private Long productId;
	private Integer quantity;
	private Double price;
}
