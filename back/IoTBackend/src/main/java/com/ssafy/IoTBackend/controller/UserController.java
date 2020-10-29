package com.ssafy.IoTBackend.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		LOGGER.info("--------------------------------------");
		LOGGER.debug("[DEBUG]");
		LOGGER.info("[INFO]");
		LOGGER.warn("[WARN]");
		LOGGER.error("[ERROR]");

		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "회원가입")
	@PostMapping("/signup")
	public ResponseEntity<String> doSignUp(Authentication authentication, User dto) throws Exception {
		LOGGER.info("--------------------------------------signup");
		
		dto.setUser_id(authentication.getPrincipal().toString());
		System.out.println("dto>>>>>>>>> "+dto.toString());
		
		int flag = service.insertUser(dto);

		if (flag == 0) return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보 가져오기")
	@GetMapping
	public ResponseEntity<User> doGetUser(Authentication authentication) throws Exception {
		LOGGER.info("--------------------------------------doGetUser");
		
		String userId = authentication.getPrincipal().toString();
		return new ResponseEntity<User>(service.selectUser(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보 수정")
	@PutMapping
	public ResponseEntity<String> doUpdateUser(Authentication authentication, User dto) throws Exception {
		LOGGER.info("--------------------------------------doUpdateUser");
		
		String userId = authentication.getPrincipal().toString();
		dto.setUser_id(userId);
		
		int flag = service.updateUser(dto);

		if (flag == 0) return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}
}
