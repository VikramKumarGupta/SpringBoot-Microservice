package com.example.delivery.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderitems")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	private Long productId;
	private Integer quantity;
	private Double price;
	public OrderItem(Long productId, Integer quantity, Double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
