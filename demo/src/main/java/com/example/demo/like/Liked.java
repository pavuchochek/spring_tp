package com.example.demo.like;

import com.example.demo.article.Article;
import com.example.demo.user.UserForum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "liked")
public class Liked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Column(nullable=false)
	@Getter
	@Setter
	private Boolean isLike;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_forum_id")
	private UserForum userForum;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="article_id")
	private Article article;


}
