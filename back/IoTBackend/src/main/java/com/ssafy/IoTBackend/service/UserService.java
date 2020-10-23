package com.ssafy.IoTBackend.service;

import com.ssafy.IoTBackend.model.User;

public interface UserService {
	
	public int selectUser(User dto) throws Exception;
	public int insertUser(User dto) throws Exception;
	public User login(User dto) throws Exception;
	
}
