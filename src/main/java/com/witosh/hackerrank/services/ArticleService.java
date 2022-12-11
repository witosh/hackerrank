package com.witosh.hackerrank.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.witosh.hackerrank.domain.Article;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleService {

	ArticleServiceClient articleClient;

	public List<Article> getArticles(int pageNumber) {
		List<Article> articles = articleClient.fetchArticleFromMockEndpoint(pageNumber);
		return filterArticles(articles);
	}
// TODO: przy page 4  Unrecognized field "comment_text
	private List<Article> filterArticles(List<Article> articles) {
		return articles.stream()
	            .filter(a -> a.getTitle() != null || a.getStoryTitle() != null)
	            .collect(Collectors.toList());
	}
}
