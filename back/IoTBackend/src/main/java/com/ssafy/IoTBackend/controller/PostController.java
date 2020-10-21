package com.ssafy.IoTBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.Post;
import com.ssafy.IoTBackend.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
@Api(value = "POST (작물 성장일기)")
public class PostController {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	@ApiOperation(value = "게시글 전체 목록 조회")
	public ResponseEntity<List<Post>> insertPost(@RequestParam String user_id) {
		List<Post> posts = null;
		try {
			posts = postService.selectPosts(user_id);
			return new ResponseEntity<>(posts, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(posts, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "게시글 작성")
	public ResponseEntity<String> insertPost(@RequestBody Post postDto) {
		try {
			postService.insertPost(postDto);
			return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}
}
