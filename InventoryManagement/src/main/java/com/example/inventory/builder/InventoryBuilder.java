package com.example.inventory.builder;

import com.example.inventory.dto.request.InventoryCreateRequest;
import com.example.inventory.dto.request.InventoryUpdateRequest;
import com.example.inventory.dto.response.InventoryResponse;
import com.example.inventory.model.Invetory;

public class InventoryBuilder {

	public static Invetory buildInventoryFromInventoryCreateRequest(InventoryCreateRequest request) {
		return Invetory.builder()
				.productId(request.getProductId())
		 .availableQuantity(request.getAvailableQuantity())
		.reserveQuantity(request.getReserveQuantity())
		.wareHouse(request.getWareHouse())
		.build();
	}
	
	public static InventoryResponse buildInventoryResponseFromInventory(Invetory invetory) {
		return InventoryResponse.builder()
				.inventoryId(invetory.getInventoryId())
				.productId(invetory.getProductId())
		.availableQuantity(invetory.getAvailableQuantity())
		.reserveQuantity(invetory.getReserveQuantity())
		.wareHouse(invetory.getWareHouse())
		.build();
	}
	
	public static Invetory buildInventoryFromInventoryUpdateRequest(Invetory inv, InventoryUpdateRequest req) {
		return Invetory.builder()
				.inventoryId(inv.getInventoryId())
		.availableQuantity(req.getAvailableQuantity())
		.reserveQuantity(req.getReserveQuantity())
		.wareHouse(req.getWareHouse())
		.build();
	}
}
