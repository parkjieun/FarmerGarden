package com.ssafy.IoTBackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.IoTBackend.model.Plant;
import com.ssafy.IoTBackend.service.PlantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8080/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/plant")
@Api(value = "Plant")
public class PlantController {

	public static final Logger LOGGER = LoggerFactory.getLogger(PlantController.class);
	public static final String SUCESS = "success";
	public static final String FAIL = "fail";

	@Autowired
	private PlantService service;

	@ApiOperation(value = "식물 리스트 가져오기", notes = "성공시  'Plant list' 반환")
	@GetMapping
	public ResponseEntity<List<Plant>> doGetPlant() throws Exception {
		LOGGER.info("--------------------------------------doGetPlant");
		return new ResponseEntity<List<Plant>>(service.selectPlant(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "식물 상세 정보 가져오기", notes = "성공시  'Plant' 반환")
	@GetMapping("/{plant_id}")
	public ResponseEntity<Plant> doGetPlantById(HttpServletRequest req, @PathVariable Integer plant_id) throws Exception {
		LOGGER.info("--------------------------------------doGetPlantById");
		return new ResponseEntity<Plant>(service.selectPlantById(plant_id), HttpStatus.OK);
	}
	
}
