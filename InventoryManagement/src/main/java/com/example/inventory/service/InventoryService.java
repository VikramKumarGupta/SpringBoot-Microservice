package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.builder.InventoryBuilder;
import com.example.inventory.dto.request.InventoryCreateRequest;
import com.example.inventory.dto.request.InventoryUpdateRequest;
import com.example.inventory.dto.response.InventoryResponse;
import com.example.inventory.exceptions.InventoryNotFoundException;
import com.example.inventory.model.Invetory;
import com.example.inventory.repoistroy.InventoryRepoistory;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepoistory _repo;

	public InventoryResponse saveInventory(InventoryCreateRequest request) {
		Invetory invetory = InventoryBuilder.buildInventoryFromInventoryCreateRequest(request);
		Invetory save = _repo.save(invetory);
		return InventoryBuilder.buildInventoryResponseFromInventory(save);
	}
	
	public List<InventoryResponse> getAllInventory() {
		List<Invetory> allInventory = _repo.findAll();
		
		List<InventoryResponse> list = allInventory.stream()
			.map(InventoryBuilder::buildInventoryResponseFromInventory)
			.toList();
		
		return list;
	}

	public InventoryResponse getInventoryById(Long id) {
		Invetory order = _repo.findById(id)
			.orElseThrow(()->new InventoryNotFoundException("Invetory not found"));
		
		return InventoryBuilder.buildInventoryResponseFromInventory(order);
	}

	public InventoryResponse updateInventory(Long id, InventoryUpdateRequest request) {
		Invetory exisitngOrder = _repo.findById(id)
			.orElseThrow(()->new InventoryNotFoundException("Order Not Found"));
		
		Invetory updateRequest = InventoryBuilder.buildInventoryFromInventoryUpdateRequest(exisitngOrder, request);
		
		return InventoryBuilder.buildInventoryResponseFromInventory(updateRequest);
	}

	public void deleteInventory(Long id) {
		if(!_repo.existsById(id)) {
			throw new InventoryNotFoundException("Order Not Existed");
		}
		_repo.deleteById(id);
	}
}
