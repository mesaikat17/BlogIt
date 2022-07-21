package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blog.Entities.Post;

@SpringBootApplication
@AutoConfiguration
public class BlogItApplication {
		
		@Bean
		Post post() {
			return new Post();
		}
	public static void main(String[] args) {
		SpringApplication.run(BlogItApplication.class, args);
		
		
	}

}
