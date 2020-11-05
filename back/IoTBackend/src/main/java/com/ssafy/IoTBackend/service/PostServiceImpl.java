package com.ssafy.IoTBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.PostMapper;
import com.ssafy.IoTBackend.model.post.CreatePostRequestDTO;
import com.ssafy.IoTBackend.model.post.Post;
import com.ssafy.IoTBackend.model.post.UpdatePostRequestDTO;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMapper postMapper;
	
	@Override
	public List<Post> selectPosts(String user_id) throws Exception {
		return postMapper.selectPosts(user_id);
	}
	
	@Override
	public Post selectPostById(Integer post_id) throws Exception {
		return postMapper.selectPostById(post_id);
	}

	@Override
	public int insertPost(CreatePostRequestDTO postDto) throws Exception {
		return postMapper.insertPost(postDto);
	}

	@Override
	public int updatePost(UpdatePostRequestDTO postDto) throws Exception {
		return postMapper.updatePost(postDto);
	}

	@Override
	public int deletePost(Integer post_id) throws Exception {
		return postMapper.deletePost(post_id);
	}

}
