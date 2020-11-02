package com.ssafy.IoTBackend.service;

import java.util.List;

import com.ssafy.IoTBackend.model.Plant;

public interface PlantService {
	
	public List<Plant> selectPlant() throws Exception;
	
	public Plant selectPlantById(int plant_id) throws Exception;

}
