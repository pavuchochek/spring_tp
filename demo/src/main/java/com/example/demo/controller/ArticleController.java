package com.example.demo.controller;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.article.Article;
import com.example.demo.user.UserForum;
import com.example.demo.user.UserRepository;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
	private final ArticleRepository repository;
	private final UserRepository userRepository;

	ArticleController(ArticleRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository=userRepository;
	}


	@GetMapping("/article")
	List<Article> all(){
		return repository.findAll();
	}

	@GetMapping("/article/{id}")
	Optional<Article> one(@PathVariable Long id){
		return repository.findById(id);
	}

	@PostMapping("/article")
	Article newArticle(@RequestBody Article article) {
		return repository.save(article);
	}


	@PutMapping("/article/{id}")
	Article replaceUser(@RequestBody Article newArticle,@PathVariable Long id){
		return repository.findById(id).map(article -> {
					article.setContenu(newArticle.getContenu());
					article.setDate(newArticle.getDate());
					return repository.save(article);
				})
				.orElseGet(() -> {
					return repository.save(newArticle);
				});
	}

	@DeleteMapping("/article/{id}")
	void suppressionUserForum(@PathVariable Long id){
		repository.deleteById(id);
	}

}
