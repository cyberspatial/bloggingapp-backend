package com.ravipsingh.bloggingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipsingh.bloggingapp.entity.Post;
import com.ravipsingh.bloggingapp.services.PostService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/home")
public class PostController {
	@Autowired
	private PostService pstService;
	
	@PostMapping("")
	@ResponseBody
	public Post addPost(@RequestBody Post post)
	{
		return pstService.savePost(post);
		
	}
	@GetMapping("/mypost/{email}")
	@ResponseBody
	public List<Post> getPostbyemail(@PathVariable String email)
	{
		return pstService.getPostbyEmail(email);
	}
	@GetMapping("/otherblog/{email}")
	@ResponseBody
	public List<Post> getOthersPostbyEmail(@PathVariable String email)
	{
		return pstService.findOthersPost(email);
	}

	
	
	
	@PutMapping("/addcomment")
	@ResponseBody
	public Post updateComment(@RequestBody Post post)
	{
		return pstService.addComment(post);
	}
	
	@DeleteMapping("/deleteBlogByPid/{pid}")
	@ResponseBody
    public boolean deletePost(@PathVariable String pid)
	{
		return pstService.deletePostByPid(pid);
	}
	
}
