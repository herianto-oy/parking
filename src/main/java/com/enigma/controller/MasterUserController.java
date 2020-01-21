package com.enigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.entity.MasterUserEntity;
import com.enigma.service.MasterUserService;

@RestController
public class MasterUserController {
	@Autowired
	private MasterUserService masterUserService;

	@PostMapping("/user")
	public ResponseEntity<MasterUserEntity> createUser(@RequestBody MasterUserEntity user) {
		MasterUserEntity response = masterUserService.createUser(user);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/user")
	public ResponseEntity<MasterUserEntity> updateUser(@RequestBody MasterUserEntity user) {
		MasterUserEntity response = masterUserService.updateUser(user);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<Page<MasterUserEntity>> findAllUser(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		Page<MasterUserEntity> response = masterUserService.findAllUser(page, size);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping("/user")
	public ResponseEntity<MasterUserEntity> deleteUser(@RequestParam("id") Long id) {
			MasterUserEntity response = masterUserService.deleteUser(id);
			if (response != null) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
	}
}
