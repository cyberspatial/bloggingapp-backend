package com.ravipsingh.bloggingapp.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	@Id
   private String pid;
	@NotBlank(message="name cannot be null")
	private String name;
	@Indexed(name="email_index",unique=true)
	@Email(message="invalid email address")
	private String email;
	@NotNull
	@Size(min=7)
	private String password;
	@NotNull
	@Size(min=7)
	private String repass;
	public User(String pid,  String name,
			String email,  String password) {
		super();
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	
   
   

}
