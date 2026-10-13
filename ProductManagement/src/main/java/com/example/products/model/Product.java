package com.example.products.model;

import jakarta.persistence.Column;
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
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	
	@Column(length = 100)
	private String description;
	
	private String brand;
	
	private Double price;
	
	private Double rating;
	public Product(String productName, String description, String brand, Double price, Double rating) {
		super();
		this.productName = productName;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.rating = rating;
	}
	

}
