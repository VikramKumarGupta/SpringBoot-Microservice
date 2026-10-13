package com.example.delivery.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUpdateRequest {
	private Long orderId;
	private String trackingNumber;
	private String shippingAddress;
	private LocalDateTime estimatedDeliveryDate;
	private LocalDateTime actualDeliveryDate;
	private String status;
}
