package com.ssafy.IoTBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.PostMapper;
import com.ssafy.IoTBackend.model.Post;

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
	public void insertPost(Post postDto) throws Exception {
		postMapper.insertPost(postDto);
	}

	@Override
	public void updatePost(Post postDto) throws Exception {
		postMapper.updatePost(postDto);
	}

	@Override
	public void deletePost(Integer post_id) throws Exception {
		postMapper.deletePost(post_id);
	}

}
