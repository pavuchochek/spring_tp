package com.example.demo.user;

import com.example.demo.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Entity
@Table(name = "user_forum")
public class UserForum {
	public enum Role{
		PUBLISHER,MODERATOR
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long id;

	@Column(nullable = false)
	@Setter
	private String username;

	@Column(nullable = false)
	@Setter
	private String password;

	@Column(name = "user_role", nullable = false)
	@Setter
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "id")
	private Collection<Article> articles;


}
