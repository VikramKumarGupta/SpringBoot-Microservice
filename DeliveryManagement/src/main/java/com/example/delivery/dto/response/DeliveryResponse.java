package com.example.delivery.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.delivery.dto.request.DeliveryUpdateRequest;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponse {
	private Long deliveryId;
	private Long orderId;
	private String trackingNumber;
	private String shippingAddress;
	private LocalDate estimatedDeliveryDate;
	private LocalDateTime actualDeliveryDate;
	private String status;
	private Double totalPrice;
}
