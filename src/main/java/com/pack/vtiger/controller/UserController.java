package com.pack.vtiger.controller;

import com.pack.vtiger.dto.UserDTO;
import com.pack.vtiger.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
		UserDTO user = userService.addUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
}
