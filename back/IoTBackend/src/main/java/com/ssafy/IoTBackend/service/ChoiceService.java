package com.ssafy.IoTBackend.service;

import com.ssafy.IoTBackend.model.Choice;

public interface ChoiceService {
	
	public String insertChoice(Choice choice) throws Exception;
	
	public int stopChoice(String choice_id) throws Exception;
}
