package com.example.gloQuora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gloQuora.dto.UserDto;
import com.example.gloQuora.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/addUserDetails")
	public ResponseEntity<Object> addUserDetails(@RequestBody UserDto userDetailsDto) {
		return new ResponseEntity<Object>(userService.addUser(userDetailsDto), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllUsersDetails")
	public ResponseEntity<Object> getAllUserDetails() {
		return new ResponseEntity<Object>(userService.getAllUserDetails(), HttpStatus.OK);
	}

	@GetMapping(value = "/getUserSpecificDetails")
	public ResponseEntity<Object> getSpecificUserDetail(@RequestParam Long userId) {
		return new ResponseEntity<Object>(userService.getSpecificUserDetails(userId), HttpStatus.OK);
	}

	@PutMapping(value = "/updateUserDetails")
	public ResponseEntity<Object> updateUserDetails(@RequestBody UserDto userDetailsDto) {
		return new ResponseEntity<Object>(userService.updateUser(userDetailsDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteUserDetails")
	public ResponseEntity<Object> deleteUserDetails(@RequestParam Long userId) {
		return new ResponseEntity<Object>(userService.deleteUser(userId), HttpStatus.OK);
	}
}
