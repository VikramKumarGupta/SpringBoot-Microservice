package com.example.users.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.builder.UserBuilder;
import com.example.users.dao.UserRepository;
import com.example.users.dto.request.UserCreateRequest;
import com.example.users.dto.request.UserUpdateRequest;
import com.example.users.dto.response.UserResponse;
import com.example.users.execption.InvalidUserIdException;
import com.example.users.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository _repo;
	
	public UserResponse save(UserCreateRequest request) {
		User user = UserBuilder.buildUserFromUserCreateRequest(request);
		User save = _repo.save(user);
		UserResponse response = UserBuilder.buildUserResponseFromUser(save);
		return response;
	}

	public List<UserResponse> getAllUsers() {
		List<User> allUsers = _repo.findAll();
		List<UserResponse> list = allUsers.stream()
			.map(UserBuilder::buildUserResponseFromUser)
			.toList();
		return list;
	}

	public UserResponse getUserById(Long userId) {
		User user = _repo.findById(userId)
			.orElseThrow(()->new InvalidUserIdException("User Not Found"));
		
		return UserBuilder.buildUserResponseFromUser(user);
	}

	public UserResponse updateUser(Long userid, UserUpdateRequest request) {
		User exisitingUser = _repo.findById(userid)
			.orElseThrow(()->new InvalidUserIdException("User Not found"));
		
		User user = UserBuilder.buildUserFromUserUpdateRequest(exisitingUser, request);
		User save = _repo.save(user);
		return UserBuilder.buildUserResponseFromUser(save);
	}

	public void deleteUser(Long userid) {
		if(!_repo.existsById(userid)) {
			throw new InvalidUserIdException("User Not Found");
		}
		_repo.deleteById(userid);
	}
}
