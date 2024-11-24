package com.springBoot.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springBoot.web.entities.User;
import com.springBoot.web.payloads.UserDto;
import com.springBoot.web.services.UserService_Srv;
import com.springBoot.web.services.impl.UserService_Impl;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService_Srv userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
		UserDto existingUser = this.userService.getUserById(id);
		if (existingUser != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(existingUser);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDto user, @PathVariable int id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.updateUser(user, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.deleteUser(id));
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

}
