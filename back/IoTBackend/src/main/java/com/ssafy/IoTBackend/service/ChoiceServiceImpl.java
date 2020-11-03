package com.ssafy.IoTBackend.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.IoTBackend.mapper.ChoiceMapper;
import com.ssafy.IoTBackend.model.Choice;

public class ChoiceServiceImpl implements ChoiceService {

	@Autowired
	private ChoiceMapper choiceMapper;
	
	@Override
	public int insertChoice(Choice choice) throws Exception {
		return choiceMapper.insertChoice(choice);
	}

}
