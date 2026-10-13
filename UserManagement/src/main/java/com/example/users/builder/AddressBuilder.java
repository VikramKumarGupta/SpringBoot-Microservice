package com.example.users.builder;

import com.example.users.dto.request.AddressCreateRequest;
import com.example.users.dto.request.AddressUpdateRequest;
import com.example.users.dto.response.AddressResponse;
import com.example.users.model.Address;

public class AddressBuilder {
	public static Address buildAddressFromAddressCreateRequest(AddressCreateRequest request) {
		return Address.builder()
			.street(request.getStreet())
			.city(request.getCity())
			.pincode(request.getPincode())
			.state(request.getState())
			.country(request.getCountry())
			.build();
	}
	
	public static AddressResponse buildAddressResponseFromAddress(Address address) {
		return AddressResponse.builder()
			.addressId(address.getAddressId())
			.street(address.getStreet())
			.city(address.getCity())
			.pincode(address.getPincode())
			.state(address.getState())
			.country(address.getCountry())
			.build();
	}
	
	public static Address buildAddressFromAddressUpdateRequest(AddressUpdateRequest request) {
		return Address.builder()
				.street(request.getStreet())
				.city(request.getCity())
				.pincode(request.getPincode())
				.state(request.getState())
				.country(request.getCountry())
				.build();
	}
}
