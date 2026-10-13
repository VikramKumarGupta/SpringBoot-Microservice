package com.example.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	private Long addressId;
	private String street;
	private String city;
	private String pincode;
	private String state;
	private String country;
}
