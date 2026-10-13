package com.example.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.products.dto.request.ProductCreateRequest;
import com.example.products.dto.request.ProductUpdateRequest;
import com.example.products.dto.response.ProductResponse;
import com.example.products.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _service;
	
	@PostMapping("/saveproduct")
	public ProductResponse saveProduct(@RequestBody ProductCreateRequest request) {
		ProductResponse saveProduct = _service.saveProduct(request);
		return saveProduct;
	}
	
	@GetMapping("/getallproducts")
	public List<ProductResponse> getAllProducts(){
		return _service.getAllProducts();
	}
	
	@GetMapping("/getproductbyid/{id}")
	public ProductResponse getProductById(@PathVariable Long id) {
		return _service.getProductById(id);
	}
	
	@PutMapping("/updateproduct/{id}")
	public ProductResponse updateProduct(@PathVariable Long id,@RequestBody ProductUpdateRequest request) {
		return _service.updateProduct(id,request);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		_service.deleteProduct(id);
	}
}
