package com.pack.vtiger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@GetMapping
	public ResponseEntity<String> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body("User Got");
	}
}
