package com.example.users.dto.response;

import com.example.users.dto.request.AddressUpdateRequest;
import com.example.users.dto.request.UserUpdateRequest;

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
