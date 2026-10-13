package com.example.inventory.dto.response;

import com.example.inventory.dto.request.InventoryUpdateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
	private Long inventoryId;
	private Long productId;
	private Integer availableQuantity;
	private Integer reserveQuantity;
	private String wareHouse;
}
