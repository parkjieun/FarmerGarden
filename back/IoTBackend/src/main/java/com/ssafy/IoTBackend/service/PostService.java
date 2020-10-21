package com.ssafy.IoTBackend.service;

import java.util.List;

import com.ssafy.IoTBackend.model.Post;

public interface PostService {

	public List<Post> selectPosts(String user_id) throws Exception;
	
	public void insertPost(Post postDto) throws Exception;
	
	public void updatePost(Post postDto) throws Exception;

	public void deletePost(Integer post_id) throws Exception;

}
