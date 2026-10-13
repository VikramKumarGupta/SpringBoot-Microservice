package com.example.inventory.repoistroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.model.Invetory;

public interface InventoryRepoistory extends JpaRepository<Invetory, Long>{

}
