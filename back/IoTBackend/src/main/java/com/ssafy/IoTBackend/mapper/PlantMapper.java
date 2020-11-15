package com.ssafy.IoTBackend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.Plant;

@Repository
@Mapper
public interface PlantMapper {

	public List<Plant> selectPlant()throws Exception;

	public Plant selectPlantById(int plant_id)throws Exception;

}

