package com.example.gloQuora.service;

import org.springframework.stereotype.Service;

import com.example.gloQuora.dto.UserDto;

@Service
public interface UserService {

	public Object addUser(UserDto userDetailsDto);

	public Object deleteUser(Long userId);

	public Object getAllUserDetails();

	public Object getSpecificUserDetails(Long userId);

	public Object updateUser(UserDto userDetailsDto);

}
