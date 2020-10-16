package com.ssafy.IoTBackend.srervice;

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
	public int selectUser(User dto) throws Exception {
		
		return mapper.selectUser(dto);
	}

}
