package com.ssafy.IoTBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.Choice;
import com.ssafy.IoTBackend.service.ChoiceService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/choice")
@Api(value = "Choice")
public class ChoiceController {
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	@Autowired
	ChoiceService choiceService;
	
	@PostMapping
	public ResponseEntity<String> startPlantChoice(Choice choice) {
		try {
			int result = choiceService.insertChoice(choice);
			if(result == 0) return new ResponseEntity<>(FAIL, HttpStatus.NOT_FOUND);
			else return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

}
