package com.ssafy.IoTBackend.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		LOGGER.info("--------------------------------------:"+service.selectUser(dto));
		LOGGER.debug("[DEBUG]");
		LOGGER.info("[INFO]");
		LOGGER.warn("[WARN]");
		LOGGER.error("[ERROR]");
        
		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}
		
}
