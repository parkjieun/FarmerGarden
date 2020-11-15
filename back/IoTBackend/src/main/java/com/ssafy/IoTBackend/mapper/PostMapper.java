package com.ssafy.IoTBackend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.post.CreatePostRequestDTO;
import com.ssafy.IoTBackend.model.post.Post;
import com.ssafy.IoTBackend.model.post.UpdatePostRequestDTO;

@Repository
@Mapper
public interface PostMapper {
	
	public List<Post> selectPosts(String user_id) throws Exception;
	
	public Post selectPostById(Integer post_id) throws Exception;
	
	public int insertPost(CreatePostRequestDTO postDto) throws Exception;

	public int updatePost(UpdatePostRequestDTO postDto) throws Exception;

	public int deletePost(Integer post_id) throws Exception;
}
