package com.ssafy.IoTBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping
	@ApiOperation(value = "게시글 작성")
	public ResponseEntity<String> insertPost(@RequestBody Post postDto) {
		try {
			postService.insertPost(postDto);
			return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}
}
