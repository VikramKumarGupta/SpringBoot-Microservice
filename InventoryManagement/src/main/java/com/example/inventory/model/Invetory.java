package com.example.inventory.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invetory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	private Long productId;
	private Integer availableQuantity;
	private Integer reserveQuantity;
	private String wareHouse;
	public Invetory(Long productId, Integer availableQuantity, Integer reserveQuantity, String wareHouse) {
		super();
		this.productId = productId;
		this.availableQuantity = availableQuantity;
		this.reserveQuantity = reserveQuantity;
		this.wareHouse = wareHouse;
	}
	
	
}
