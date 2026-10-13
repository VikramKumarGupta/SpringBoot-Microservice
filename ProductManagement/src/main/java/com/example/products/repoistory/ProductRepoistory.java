package com.example.products.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.products.model.Product;

@Repository
public interface ProductRepoistory extends JpaRepository<Product, Long>{

}
