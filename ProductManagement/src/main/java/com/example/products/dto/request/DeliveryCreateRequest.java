package com.example.products.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryCreateRequest {
	private Long orderId;
	private String trackingNumber;
	private String shippingAddress;
	private LocalDate estimatedDeliveryDate;
	private String status;
}
