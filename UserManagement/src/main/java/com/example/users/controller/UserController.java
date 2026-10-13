package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.request.UserCreateRequest;
import com.example.users.dto.request.UserUpdateRequest;
import com.example.users.dto.response.UserResponse;
import com.example.users.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService _service;
	
	@PostMapping("/saveuser")
	public UserResponse saveUser(@RequestBody UserCreateRequest request) {
		UserResponse save = _service.save(request);
		return save;
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		return ResponseEntity.ok(_service.getAllUsers());
	}
	
	@GetMapping("/getuserbyid/{userid}")
	public UserResponse getUserById(@PathVariable Long userid){
		UserResponse userById = _service.getUserById(userid);
		
		return userById;
	}
	
	@PutMapping("/updateuser/{userid}")
	public UserResponse updateUser(@PathVariable Long userid,@RequestBody UserUpdateRequest request) {
		UserResponse updateUser = _service.updateUser(userid,request);
		return updateUser;
	}
	
	@DeleteMapping("/deleteuser/{userid}")
	public void deleteUser(@PathVariable Long userid) {
		_service.deleteUser(userid);
	}
}
