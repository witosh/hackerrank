package com.witosh.hackerrank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.witosh.hackerrank.domain.Article;
import com.witosh.hackerrank.services.ArticleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ArticlesController {

	private final ArticleService service;

	@GetMapping("articles/{pageNumber}")
	public List<Article> getArticles(@PathVariable("pageNumber") int pageNumber) {
		return service.getArticles(pageNumber);
	}
}
