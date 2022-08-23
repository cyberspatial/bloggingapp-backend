package com.ravipsingh.bloggingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ravipsingh.bloggingapp.entity.Post;
import com.ravipsingh.bloggingapp.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postrepo;
	
	public Post savePost(Post post)
	{
		return postrepo.save(post);
	}
	
	public List<Post> getPostbyEmail(String email)
	{
		return postrepo.findAllByEmail(email);	
	}
	
	public boolean deletePostByPid(String pid) {
       Post existingPost = postrepo.findByPid(pid);
       if(existingPost!=null)
       {
    	   postrepo.deleteByPid(pid);
    	   return true;
       }
       return false;
    }
	
	public List<Post> findOthersPost(String email)
	{
		return postrepo.getOthersPost(email);
	}
	
    public Post addComment(Post post)
	{
		Post existingPost = postrepo.findByPid(post.getPid());
	
			System.out.println(post.getComments());
			existingPost.setComments(post.getComments());
			postrepo.save(existingPost);
			
		return post;
		
	}

}
