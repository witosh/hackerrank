package com.witosh.hackerrank.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
	
    @JsonProperty("num_comments")
    private  int numComments;
    @JsonProperty("author")
    private  String author;
    @JsonProperty("story_title")
    private  String storyTitle;
    @JsonProperty("parent_id")
    private  long parentId;
    @JsonProperty("story_id")
    private  long storyId;
    @JsonProperty("created_at")
    private  Date createdAt;
    @JsonProperty("title")
    private  String title;
    @JsonProperty("story_url")
    private  String storyUrl;
    @JsonProperty("url")
    private  String url;
}
