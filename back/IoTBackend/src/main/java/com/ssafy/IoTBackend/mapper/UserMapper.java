package com.ssafy.IoTBackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.User;

@Repository
@Mapper
public interface UserMapper {

	public int existsByUserId(String socialId) throws Exception;
	
	public String findId(String socialId) throws Exception;
	
	public int insertUser(User dto) throws Exception;
	
	public User selectUser(String user_id) throws Exception;

	public int updateUser(User dto);
}

