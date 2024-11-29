package com.example.demo.controller;

import com.example.demo.user.UserForum;
import com.example.demo.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	private final UserRepository  repository;
	UserController(UserRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/user")
	List<UserForum> all(){
		return repository.findAll();
	}

	@PostMapping("/user")
	UserForum newUserForum(@RequestBody UserForum userForum) {
		return repository.save(userForum);
	}

	@DeleteMapping("/user/{id}")
	public String suppression(@PathVariable Long id){
		return "Je supprime un utilisateur avec id"+id;
	}
}
