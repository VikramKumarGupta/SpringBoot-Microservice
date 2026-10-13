package com.example.delivery.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.delivery.model.Delivery;

@Repository
public interface DeliveryRepoistory extends JpaRepository<Delivery, Long>{

}
