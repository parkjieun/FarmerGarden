package com.ssafy.IoTBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.Choice;
import com.ssafy.IoTBackend.model.User;
import com.ssafy.IoTBackend.service.ChoiceService;
import com.ssafy.IoTBackend.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/choice")
@Api(value = "Choice")
public class ChoiceController {
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	@Autowired
	ChoiceService choiceService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ApiOperation(value = "재배할 작물 선택", notes = "성공시 생성된 choice_id 반환, 실패시 'fail' 반환")
	public ResponseEntity<String> startPlantChoice(Authentication authentication, @RequestParam String plant_id) {
		String userId = authentication.getPrincipal().toString();
		try {
			User user = userService.selectUser(userId);
			if(user != null) {
				Choice choice = new Choice();
				choice.setUser_id(userId);
				choice.setPlant_id(plant_id);
				
				String new_choice_id = choiceService.insertChoice(choice);
				if(new_choice_id.equals(null)) return new ResponseEntity<>(FAIL, HttpStatus.NOT_FOUND);
				else return new ResponseEntity<>(new_choice_id, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("유효하지 않은 인증 토큰입니다.", HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	@ApiOperation(value = "현재 재배중인 작물 재배 중단", notes = "성공시 'success' 실패시 'fail' 반환")
	public ResponseEntity<String> stopPlantChoice(@RequestParam String choice_id) {
		try {
			int result = choiceService.stopChoice(choice_id);
			if(result == 0) return new ResponseEntity<>(FAIL, HttpStatus.NOT_FOUND);
			else return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(FAIL, HttpStatus.CONFLICT);
		}
	}

}
