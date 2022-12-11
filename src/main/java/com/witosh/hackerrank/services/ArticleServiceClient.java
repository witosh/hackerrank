package com.witosh.hackerrank.services;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.witosh.hackerrank.domain.Article;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleServiceClient {

	private static final String HACKER_RANK_URL = "https://jsonmock.hackerrank.com/api/articles?page={pageNumber}";

	@Autowired
	private final RestTemplate restTemplate;
	private final MaptoArticles mapper;

	public List<Article> fetchArticleFromMockEndpoint(int pageNumber) {
		URI uri = prepareUriForArticles(pageNumber);
		String response = getRestTemplateResponse(uri);
		return  mapper.tryToConvertToListOfArticles(response);
	}

	private String getRestTemplateResponse(URI uri) {
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

	private URI prepareUriForArticles(int pageNumber) {
		UriTemplate template = new UriTemplate(HACKER_RANK_URL);

		HashMap<String, String> uriParam = new HashMap<>();
		uriParam.put("pageNumber", Integer.toString(pageNumber));

		return template.expand(uriParam);
	}
}
