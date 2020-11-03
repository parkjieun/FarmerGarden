package com.ssafy.IoTBackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.model.Choice;

@Service
@Transactional
public interface ChoiceService {
	
	public int insertChoice(Choice choice) throws Exception;
	
}
