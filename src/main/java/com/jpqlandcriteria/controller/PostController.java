package com.jpqlandcriteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpqlandcriteria.model.Post;
import com.jpqlandcriteria.repository.PostDaoService;

@RestController
public class PostController {
	
	@Autowired
	private PostDaoService postService;
	
	@GetMapping("/api/posts")
	public List<Post> getPostByTitle(@RequestParam("title") String title){
	   return postService.getPostByTitleName(title);
	}

}
