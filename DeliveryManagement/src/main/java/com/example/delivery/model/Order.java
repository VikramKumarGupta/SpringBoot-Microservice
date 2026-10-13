package com.example.delivery.model;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long userId;
	private Double totalPrice;
	private String status;
	
	private LocalDateTime orderDate;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true )
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Order(Long userId, Double totalPrice, String status, LocalDateTime orderDate) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderDate = orderDate;
	}
	
}
