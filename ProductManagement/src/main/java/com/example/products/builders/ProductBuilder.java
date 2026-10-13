package com.example.products.builders;

import com.example.products.dto.request.ProductCreateRequest;
import com.example.products.dto.request.ProductUpdateRequest;
import com.example.products.dto.response.ProductResponse;
import com.example.products.model.Product;

public class ProductBuilder {
	
	public static Product buildProductFromProductCreqteRequest(ProductCreateRequest request) {
		return Product.builder()
		.productName(request.getProductName())
		.description(request.getDescription())
		.brand(request.getBrand())
		.price(request.getPrice())
		.rating(request.getRating())
		.build();
	}
	
	public static ProductResponse buildProductResponseFromProduct(Product product) {
		return ProductResponse.builder()
				.productId(product.getProductId())
				.productName(product.getProductName())
				.description(product.getDescription())
				.brand(product.getBrand())
				.price(product.getPrice())
				.rating(product.getRating())
				.build();
	}
	
	public static Product buildProductFromProductUpdateRequest(Product exisitingProduct,ProductUpdateRequest request) {
		return Product.builder()
				.productId(exisitingProduct.getProductId())
				.productName(request.getProductName())
				.description(request.getDescription())
				.brand(request.getBrand())
				.price(request.getPrice())
				.rating(request.getRating())
				.build();
	}
}
