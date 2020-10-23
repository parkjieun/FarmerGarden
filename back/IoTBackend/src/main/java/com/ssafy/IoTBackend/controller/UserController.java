package com.ssafy.IoTBackend.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.User;
import com.ssafy.IoTBackend.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8080/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
@Api(value = "USER")
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	public static final String SUCESS = "success";
	public static final String FAIL = "fail";

	@Autowired
	private UserService service;

	@ApiOperation(value = "테스트")
	@GetMapping("/test")
	public ResponseEntity<String> doBuy(User dto) throws Exception {
		LOGGER.info("--------------------------------------:" + service.selectUser(dto));
		LOGGER.debug("[DEBUG]");
		LOGGER.info("[INFO]");
		LOGGER.warn("[WARN]");
		LOGGER.error("[ERROR]");

		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}

//	@ApiOperation(value = "회원가입")
//	@PostMapping("/signup")
//	public ResponseEntity<String> doSignUp(User dto) throws Exception {
//		LOGGER.info("--------------------------------------signup");
//		int result = service.insertUser(dto);
//		System.out.println(">" + result);
//		// 실패시 500에러
//		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
//	}
//
//	@ApiOperation(value = "로그인. 입력된 아이디와 비밀번호가 유효하면 jwt 토큰을 발급한다.")
//	@GetMapping("/login")
//	public ResponseEntity<String> doLogin(User dto) throws Exception {
//		LOGGER.info("--------------------------------------login");
//		User loggedIn = service.login(dto);
//
//		if (loggedIn != null) {
//			System.out.println(">" + loggedIn.toString());
//		} else {
//		}
//
//		// 실패시 500에러
//		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
//	}


	// 회원수정
}
