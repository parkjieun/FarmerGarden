package com.ssafy.IoTBackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.Choice;

@Repository
@Mapper
public interface ChoiceMapper {
	
	public int insertChoice(Choice choice) throws Exception;
	
	public int stopChoice(String choice_id) throws Exception;
}
