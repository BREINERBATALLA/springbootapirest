package com.example.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.User;
import com.example.apirest.service.UserService;

@RestController
@RequestMapping("/apirest")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable Integer id) {
		userService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
