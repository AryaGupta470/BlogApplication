package com.springBoot.web.services.impl;

import java.text.Collator;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springBoot.web.entities.User;
import com.springBoot.web.exception.ResourceNotFoundException;
import com.springBoot.web.payloads.CategoryDto;
import com.springBoot.web.payloads.UserDto;
import com.springBoot.web.repository.UserRepo;
import com.springBoot.web.services.UserService_Srv;

@Service
public class UserService_Impl implements UserService_Srv {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);
		UserDto savedUser = this.modelMapper.map(userRepo.save(user), UserDto.class);
		return savedUser;
	}

	@Override
	public String updateUser(UserDto user, int id) {

		User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User is not found with Id"));

		UserDto existingUserDto = this.modelMapper.map(existingUser, UserDto.class);
		existingUserDto.setUserName(user.getUserName());
		existingUserDto.setAbout(user.getAbout());
		existingUserDto.setEmail(user.getEmail());
		existingUserDto.setPassword(user.getPassword());

		userRepo.save(this.modelMapper.map(existingUserDto, User.class));

		return "User Updated Successfully..";
	}

	@Override
	public UserDto getUserById(int id) {
		if (userRepo.existsById(id)) {
			Optional<User> user = userRepo.findById(id);
			return this.modelMapper.map(user, UserDto.class);
		} else {
			return null;// return the response entity with no body
		}
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> lstUsers = userRepo.findAll();
		List<UserDto> lstUserDto = lstUsers.stream().map((userDto) -> this.modelMapper.map(userDto, UserDto.class))
				.collect(Collectors.toList());
		if (lstUserDto != null) {
			return lstUserDto;
		} else {
			return null;
		}
	}

	@Override
	public String deleteUser(int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.deleteById(id);
			return "User Deleted Successfully..";
		} else {
			return "User Not Found...";
		}
	}

}
