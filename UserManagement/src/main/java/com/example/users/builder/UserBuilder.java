package com.example.users.builder;

import com.example.users.dto.request.AddressCreateRequest;
import com.example.users.dto.request.UserCreateRequest;
import com.example.users.dto.request.UserUpdateRequest;
import com.example.users.dto.response.UserResponse;
import com.example.users.model.Address;
import com.example.users.model.User;

public class UserBuilder {

	public static User buildUserFromUserCreateRequest(UserCreateRequest request) {
		return User.builder()
			.userName(request.getUserName())
			.email(request.getEmail())
			.password(request.getPassword())
			.phoneNumber(request.getPhoneNum())
			.address(AddressBuilder.buildAddressFromAddressCreateRequest(request.getAddress()))
			.build();
	}
	
	public static UserResponse buildUserResponseFromUser(User user) {
		return UserResponse.builder()
			.userId(user.getUserId())
			.userName(user.getUserName())
			.email(user.getEmail())
			.phoneNum(user.getPhoneNumber())
			.address(AddressBuilder.buildAddressResponseFromAddress(user.getAddress()))
			.build();
	}
	
	public static User buildUserFromUserUpdateRequest(User exisitingUser,UserUpdateRequest request) {
		return User.builder()
				.userId(exisitingUser.getUserId())
				.userName(request.getUserName())
				.email(request.getEmail())
				.password(request.getPassword())
				.phoneNumber(request.getPhoneNum())
				.address(AddressBuilder.buildAddressFromAddressUpdateRequest(request.getAddress()))
				.build();
	}
}
