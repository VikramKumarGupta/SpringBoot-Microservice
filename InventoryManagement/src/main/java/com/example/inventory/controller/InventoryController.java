package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.dto.request.InventoryCreateRequest;
import com.example.inventory.dto.request.InventoryUpdateRequest;
import com.example.inventory.dto.response.InventoryResponse;
import com.example.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService _service;
	
	@PostMapping("/saveinventory")
	public InventoryResponse saveInventory(@RequestBody InventoryCreateRequest request) {
		InventoryResponse saveProduct = _service.saveInventory(request);
		return saveProduct;
	}
	
	@GetMapping("/getallinventory")
	public List<InventoryResponse> getAllInventory(){
		return _service.getAllInventory();
	}
	
	@GetMapping("/getinventorybyid/{id}")
	public InventoryResponse getInventoryById(@PathVariable Long id) {
		return _service.getInventoryById(id);
	}
	
	@PutMapping("/updateinventory/{id}")
	public InventoryResponse updateInventory(@PathVariable Long id,@RequestBody InventoryUpdateRequest request) {
		return _service.updateInventory(id,request);
	}
	
	@DeleteMapping("/deleteinventory/{id}")
	public void deleteInventory(@PathVariable Long id) {
		_service.deleteInventory(id);
	}
}
