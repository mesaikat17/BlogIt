package com.blog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.Entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
