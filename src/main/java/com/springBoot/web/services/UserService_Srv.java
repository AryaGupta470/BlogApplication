package com.springBoot.web.services;

import java.util.List;

import com.springBoot.web.entities.User;
import com.springBoot.web.payloads.UserDto;

public interface UserService_Srv {

	public UserDto createUser(UserDto user);

	public String updateUser(UserDto user, int id);

	public UserDto getUserById(int id);

	public List<UserDto> getAllUsers();
	
	public String deleteUser(int id);


}
