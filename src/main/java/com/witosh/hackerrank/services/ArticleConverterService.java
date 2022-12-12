package com.witosh.hackerrank.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witosh.hackerrank.domain.Article;

@Service
public class ArticleConverterService {

	public List<Article> tryToConvertToListOfArticles(String response) {
		List<Article> articles = new ArrayList<>();
		try {
			articles = convertToListOfArticles(response);
		} catch (JsonProcessingException | JSONException e) {
			e.printStackTrace();
		}
		return articles;
	}

	private List<Article> convertToListOfArticles(String response)
			throws JsonMappingException, JsonProcessingException, JSONException {
		List<Article> articles = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();

		JSONArray arr = getJsonArray(response);
		for (int i = 0; i < arr.length(); i++) {
			Article article = objectMapper.readValue(arr.getJSONObject(i).toString(), Article.class);
			articles.add(article);
		}
		return articles;
	}

	private JSONArray getJsonArray(String response) {
		JSONObject jsonObject = new JSONObject(response);
		return jsonObject.getJSONArray("data");
	}
}
