package com.ssafy.IoTBackend.service;

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
	public void insertPost(Post postDto) throws Exception {
		postMapper.insertPost(postDto);
	}

}
