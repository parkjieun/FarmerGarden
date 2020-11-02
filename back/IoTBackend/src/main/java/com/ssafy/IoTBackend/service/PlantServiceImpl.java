package com.ssafy.IoTBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.PlantMapper;
import com.ssafy.IoTBackend.model.Plant;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantMapper mapper;

	@Override
	public List<Plant> selectPlant() throws Exception {
		return  mapper.selectPlant();
	}

	@Override
	public Plant selectPlantById(int plant_id) throws Exception {
		return mapper.selectPlantById(plant_id);
	}


}
