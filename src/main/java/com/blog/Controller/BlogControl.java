package com.blog.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Entities.Post;
import com.blog.Service.PostService;

@RestController
@RequestMapping("/api")
public class BlogControl {
	
	@Autowired
	Post post;
	
	@Autowired
	PostService postService;

	@GetMapping("/allPosts")
	public ResponseEntity<List<Post>> getAllPost(){
		List<Post> getallPost = postService.getallPost();
		
		if(getallPost.size()==0) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.ok().body(getallPost);
		}
	
	@PostMapping("/newPost")
	public ResponseEntity<Post> addData(@RequestBody Post post){
		Post newPost = postService.newPost(post);
		return ResponseEntity.ok().body(newPost);
	}
	
	@GetMapping("/singlePost/{id}")
	public ResponseEntity<Post> getSinglePost(@PathVariable("id") long id){
		Optional<Post> postByID = postService.getPostByID(id);
		if(postByID == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.of(postByID);
	}
	
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable("id") long id){
		if(postService.getPostByID(id)==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
		Post updatePost = postService.updatePost(post, id);
		return ResponseEntity.ok().body(updatePost);
		}
	}
	
	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable("id") long id){
		if(postService.getPostByID(id)==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
		postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	}
	
	
}
