package com.example.demo.article;

import com.example.demo.user.UserForum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;


	@Column(nullable = false)
	@Getter
	@Setter
	private Date date;

	@Column(nullable = false)
	@Getter
	@Setter
	private String contenu;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private UserForum userForum;

}

