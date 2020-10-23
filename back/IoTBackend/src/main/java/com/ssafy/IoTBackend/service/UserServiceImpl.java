package com.ssafy.IoTBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.UserMapper;
import com.ssafy.IoTBackend.model.User;
import com.ssafy.IoTBackend.util.Encrypter;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	Encrypter encrypter;

	@Override
	public int selectUser(User dto) throws Exception {

		return mapper.selectUser(dto);
	}

	@Override
	public int insertUser(User dto) throws Exception {
		// 암호화
		String hashedPassword = encrypter.encrypt(dto.getUser_pwd());
		dto.setUser_pwd(hashedPassword);

		return mapper.insertUser(dto);
	}

	@Override
	public User login(User dto) throws Exception {
		User loggedIn = mapper.login(dto);

		if (loggedIn == null) { // 해당하는 유저가 없음
			return null;
		} else {
			try {
				if (encrypter.check(dto.getUser_pwd(), loggedIn.getUser_pwd())) {
					return loggedIn;
				} else {
					return null;
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

}
