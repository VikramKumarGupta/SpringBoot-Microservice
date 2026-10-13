package com.example.products.dto.request;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {
	private Long userId;
	private String status;
	private List<OrderItemCreateRequest> ordeItems;
}
