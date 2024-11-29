package com.example.demo.controller;

import com.example.demo.user.UserForum;
import com.example.demo.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/user/{id}")
	Optional<UserForum> one(@PathVariable Long id){
		return repository.findById(id);
	}

	@PostMapping("/user")
	UserForum newUserForum(@RequestBody UserForum userForum) {
		return repository.save(userForum);
	}

	@PutMapping("/user/{id}")
	UserForum replaceUser(@RequestBody UserForum userForum,@PathVariable Long id){
		return repository.findById(id).map(user -> {
			user.setUsername(userForum.getUsername());
			user.setPassword(userForum.getPassword());
			user.setRole(userForum.getRole());
			return repository.save(user);
		})
				.orElseGet(() -> {
					return repository.save(userForum);
				});
	}

	@DeleteMapping("/user/{id}")
	void suppressionUserForum(@PathVariable Long id){
		repository.deleteById(id);
	}

}
