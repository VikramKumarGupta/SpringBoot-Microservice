package com.example.inventory.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryCreateRequest {
	private Long productId;
	private Integer availableQuantity;
	private Integer reserveQuantity;
	private String wareHouse;
}
