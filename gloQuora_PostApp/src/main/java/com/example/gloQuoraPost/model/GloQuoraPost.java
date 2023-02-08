package com.example.gloQuoraPost.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gloQuoraPost")
public class GloQuoraPost {

	private String id;

	@NotBlank
	private String userId;

	@NotBlank
	private String title;

	@NotBlank
	private String body;
	// getters, setters and constructors

	public GloQuoraPost() {
		super();
	}

	public GloQuoraPost(String id, @NotBlank String userId, @NotBlank String title, @NotBlank String body) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "GloQuoraPost [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + "]";
	}

}
