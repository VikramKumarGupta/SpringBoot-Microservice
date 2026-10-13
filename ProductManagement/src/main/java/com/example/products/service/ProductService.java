package com.example.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.builders.ProductBuilder;
import com.example.products.dto.request.ProductCreateRequest;
import com.example.products.dto.request.ProductUpdateRequest;
import com.example.products.dto.response.ProductResponse;
import com.example.products.exceptions.ProductNotFoundException;
import com.example.products.model.Product;
import com.example.products.repoistory.ProductRepoistory;

@Service
public class ProductService {

	@Autowired
	ProductRepoistory _repo;
	
	public ProductResponse saveProduct(ProductCreateRequest request) {
		Product product = ProductBuilder.buildProductFromProductCreqteRequest(request);
		Product save = _repo.save(product);
		ProductResponse response = ProductBuilder.buildProductResponseFromProduct(save);
		return response;
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> allProducts = _repo.findAll();
		
		List<ProductResponse> list = allProducts.stream()
			.map(ProductBuilder::buildProductResponseFromProduct)
			.toList();
		
		return list;
	}

	public ProductResponse getProductById(Long id) {
		Product product = _repo.findById(id)
			.orElseThrow(()->new ProductNotFoundException("Product not found"));
		
		return ProductBuilder.buildProductResponseFromProduct(product);
	}

	public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
		Product exisitingProduct = _repo.findById(id)
			.orElseThrow(()->new ProductNotFoundException("Product Not Found"));
		
		Product updateRequest = ProductBuilder.buildProductFromProductUpdateRequest(exisitingProduct, request);
		
		return ProductBuilder.buildProductResponseFromProduct(updateRequest);
	}

	public void deleteProduct(Long id) {
		if(!_repo.existsById(id)) {
			throw new ProductNotFoundException("Product Not Existed");
		}
		_repo.deleteById(id);
	}

}
