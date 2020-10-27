package com.ssafy.IoTBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.post.CreatePostRequestDTO;
import com.ssafy.IoTBackend.model.post.Post;
import com.ssafy.IoTBackend.model.post.UpdatePostRequestDTO;
import com.ssafy.IoTBackend.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
@Api(value = "POST (성장일기)")
public class PostController {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	@ApiOperation(value = "유저가 작성한 게시글 전체 목록 조회", 
		notes = "유저 아이디 params에 담아 요청하면 해당 유저가 작성한 post 리스트 반환")
	public ResponseEntity<List<Post>> selectPosts(@RequestParam String user_id) {
		List<Post> posts = null;
		try {
			posts = postService.selectPosts(user_id);
			return new ResponseEntity<>(posts, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(posts, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{post_id}")
	@ApiOperation(value = "특정 게시글 상세 조회",
		notes = "포스트 아이디를 url에 넣어 요청하면 해당 post 정보 반환")
	public ResponseEntity<Post> selectPostById(@PathVariable Integer post_id) {
		Post post = null;
		try {
			post = postService.selectPostById(post_id);
			return new ResponseEntity<>(post, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(post, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "게시글 작성", notes = "성공시 'success' 실패시 'fail' 반환")
	public ResponseEntity<String> createPost(@RequestBody CreatePostRequestDTO postDto) {
		try {
			postService.insertPost(postDto);
			return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	@ApiOperation(value = "게시글 수정", notes = "성공시 'success' 실패시 'fail' 반환")
	public ResponseEntity<String> updatePost(@RequestBody UpdatePostRequestDTO postDto) {
		try {
			postService.updatePost(postDto);
			return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	@ApiOperation(value = "게시글 삭제", notes = "성공시 'success' 실패시 'fail' 반환")
	public ResponseEntity<String> deletePost(@RequestParam Integer post_id) {
		try {
			postService.deletePost(post_id);
			return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}
}
