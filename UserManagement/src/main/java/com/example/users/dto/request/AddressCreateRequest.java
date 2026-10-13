package com.example.users.dto.request;

import com.example.users.model.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressCreateRequest {
	
	private String street;
	private String city;
	private String pincode;
	private String state;
	private String country;
}
