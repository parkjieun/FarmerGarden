package com.ssafy.IoTBackend.service;

import java.util.List;

import com.ssafy.IoTBackend.model.post.CreatePostRequestDTO;
import com.ssafy.IoTBackend.model.post.Post;
import com.ssafy.IoTBackend.model.post.UpdatePostRequestDTO;

public interface PostService {

	public List<Post> selectPosts(String user_id) throws Exception;
	
	public void insertPost(CreatePostRequestDTO postDto) throws Exception;
	
	public void updatePost(UpdatePostRequestDTO postDto) throws Exception;

	public void deletePost(Integer post_id) throws Exception;

}
