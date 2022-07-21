package com.blog.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.PostRepository;
import com.blog.Entities.Post;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	Post post;
	
	public List<Post> getallPost(){
		List<Post> posts = postRepository.findAll();
		return posts;
	}
	
	public Post newPost(Post post) {
		Date date = new Date();
		post.setDate(date);
		return postRepository.save(post);
		
	}
	
	public Optional<Post> getPostByID(long id) {
		Optional<Post> post = null;
		post = postRepository.findById(id);
		return post;
	}
	
	public Post updatePost(Post post, long id) {
		post.setId(id);
		return postRepository.save(post);
	}
	
	public void deletePost(long id) {
		postRepository.deleteById(id);
	}

}
