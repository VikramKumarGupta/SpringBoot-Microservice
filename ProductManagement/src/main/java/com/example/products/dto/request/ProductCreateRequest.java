package com.example.products.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequest {
	
	private String productName;
	
	private String description;
	
	private String brand;
	
	private Double price;
	
	private Double rating;
}
