package com.example.users.dto.response;

import com.example.users.dto.request.AddressCreateRequest;
import com.example.users.dto.request.UserCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private Long userId;
	private String userName;
	private String email;
	private String phoneNum;
	private AddressResponse address;
}
