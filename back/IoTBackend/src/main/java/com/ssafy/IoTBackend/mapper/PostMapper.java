package com.ssafy.IoTBackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.Post;

@Repository
@Mapper
public interface PostMapper {
	
	void insertPost(Post postDto) throws Exception;

}
