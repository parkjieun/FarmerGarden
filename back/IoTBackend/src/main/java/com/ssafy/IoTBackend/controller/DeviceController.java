package com.ssafy.IoTBackend.controller;

import java.security.MessageDigest;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.Device;
import com.ssafy.IoTBackend.model.User;
import com.ssafy.IoTBackend.service.DeviceService;
import com.ssafy.IoTBackend.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8080/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/device")
@Api(value = "Device")
public class DeviceController {

	public static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);
	public static final String SUCESS = "success";
	public static final String FAIL = "fail";

	@Autowired
	private DeviceService service;

	@ApiOperation(value = "디바이스 추가", notes = "성공시 'success' 실패시 'fail' 반환")
	@PostMapping
	public ResponseEntity<String> doInsertDevice(Authentication authentication, Device dto) throws Exception {
		LOGGER.info("--------------------------------------doInsertDevice");
		
		dto.setUser_id(authentication.getPrincipal().toString());
		int flag = service.insertDevice(dto);

		if (flag == 0) return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "디바이스 조회", notes = "성공시  'User' 반환")
	@GetMapping
	public ResponseEntity<Device> doSelectDevice(Authentication authentication) throws Exception {
		LOGGER.info("--------------------------------------doSelectDevice");
		
		String userId = authentication.getPrincipal().toString();
		return new ResponseEntity<Device>(service.selectDevice(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "디바이스 수정", notes = "성공시 'success' 실패시 'fail' 반환")
	@PutMapping
	public ResponseEntity<String> doUpdateDevice(Authentication authentication, Device dto) throws Exception {
		LOGGER.info("--------------------------------------doUpdateDevice");
		
		String userId = authentication.getPrincipal().toString();
		dto.setUser_id(userId);
		
		int flag = service.updateDevice(dto);

		if (flag == 0) return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>(SUCESS, HttpStatus.OK);
	}
}
