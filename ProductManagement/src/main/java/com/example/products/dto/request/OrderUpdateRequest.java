package com.example.products.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest {
	private Long userId;
	private String status;
	private List<OrderItemUpdateRequest> ordeItems;
}
