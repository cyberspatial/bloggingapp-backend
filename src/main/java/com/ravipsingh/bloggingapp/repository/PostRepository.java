package com.ravipsingh.bloggingapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ravipsingh.bloggingapp.entity.Post;

public interface PostRepository extends MongoRepository<Post,String> {

	List<Post> findAllByEmail(String email);

	Post findByPid(String pid);
	
	@Query("{email:{$ne:?0}}")
	List<Post> getOthersPost(String email);

	void deleteByPid(String pid);
}
