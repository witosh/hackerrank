package com.witosh.hackerrank.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.witosh.hackerrank.domain.Article;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleService {

	ArticleRestClientService articleClient;

	public List<Article> getArticles(int pageNumber) {
		List<Article> articles = articleClient.fetchArticleFromMockEndpoint(pageNumber);
		List<Article> filteredTitle = filterByTitle(articles);
		List<Article> mostViewed = filterByMostViewed(articles);
		return mostViewed;
	}

// TODO: przy page 4  Unrecognized field "comment_text
	private List<Article> filterByTitle(List<Article> articles) {
		return articles.stream().filter(a -> a.getTitle() != null || a.getStoryTitle() != null)
				.collect(Collectors.toList());
	}

	private List<Article> filterByMostViewed(List<Article> articles) {
		return articles.stream().sorted((o1, o2) -> Integer.compare(o1.getNumComments(), o2.getNumComments()))
				.skip(articles.size() - 2).collect(Collectors.toList());
	}
}
