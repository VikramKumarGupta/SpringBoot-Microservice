package com.example.delivery.builder;

import com.example.delivery.dto.request.DeliveryCreateRequest;
import com.example.delivery.dto.response.DeliveryResponse;
import com.example.delivery.model.Delivery;

public class DeliveryBuilder {
	
	public static Delivery buildDeliverFromDeliveryCreateRequest(DeliveryCreateRequest req) {
		return Delivery.builder()
				.orderId(req.getOrderId())
				.trackingNumber(req.getTrackingNumber())
				.shippingAddress(req.getShippingAddress())
				.estimatedDeliveryDate(req.getEstimatedDeliveryDate())
				.status(req.getStatus())
				.build();
	}
	
	public static DeliveryResponse buildDeliveryresponseFromDelivery(Delivery del) {
		return DeliveryResponse.builder()
				.deliveryId(del.getDeliveryId())
				.orderId(del.getOrderId())
				.trackingNumber(del.getTrackingNumber())
				.shippingAddress(del.getShippingAddress())
				.estimatedDeliveryDate(del.getEstimatedDeliveryDate())
				.actualDeliveryDate(del.getActualDeliveryDate())
				.status(del.getStatus())
				.build();
	}
	
}
