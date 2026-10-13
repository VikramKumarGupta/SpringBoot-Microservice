package com.example.products.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.products.model.Order;

@Repository
public interface OrderRepoistory extends JpaRepository<Order, Long>{

}
