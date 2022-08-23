package com.ravipsingh.bloggingapp.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class Post {
    @Id
	private String pid;
	private String email;
	private String title;
	private String content;
	private HashMap<String,String> comments;
	public Post(String pid, String email, String title, String content, HashMap<String, String> comments) {
		super();
		this.pid = pid;
		this.email = email;
		this.title = title;
		this.content = content;
		this.comments = comments;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public HashMap<String, String> getComments() {
		return comments;
	}
	public void setComments(HashMap<String, String> comments) {
		this.comments = comments;
	}
	

	
}
