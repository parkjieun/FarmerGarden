package com.ssafy.IoTBackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.User;

@Repository
@Mapper
public interface UserMapper {

	public int selectUser(User dto) throws Exception;

	public int insertUser(User dto) throws Exception;

	public User login(User dto)  throws Exception;

}
