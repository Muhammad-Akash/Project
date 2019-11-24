package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserServices.UserService;
import com.example.demo.dto.UserDto;
import com.example.demo.request.UserRequestBody;
import com.example.demo.response.UserResponse;

//added a commit
//added 2nd commit
@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "This string was called";
	}
	
	@PostMapping
	public UserResponse CreateUser (@RequestBody UserRequestBody userDetails) {
		UserResponse returnValue = new UserResponse();
		
		UserDto userdto = new UserDto();
		BeanUtils.copyProperties(userDetails,  userdto);
		
		UserDto createdUser = userService.createUser(userdto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}

}
