package com.ssafy.IoTBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.UserMapper;
import com.ssafy.IoTBackend.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public User selectUser(String user_id) throws Exception {
		return mapper.selectUser(user_id);
	}

	@Override
	public int insertUser(User dto) throws Exception {
		return mapper.insertUser(dto);
	}

}
