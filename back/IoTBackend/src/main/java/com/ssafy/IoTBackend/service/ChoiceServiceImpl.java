package com.ssafy.IoTBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.CalendarMapper;
import com.ssafy.IoTBackend.mapper.ChoiceMapper;
import com.ssafy.IoTBackend.model.Choice;
import com.ssafy.IoTBackend.model.calendar.Calendar;
import com.ssafy.IoTBackend.model.calendar.CreateCalendarRequestDTO;

@Service
@Transactional
public class ChoiceServiceImpl implements ChoiceService {

	@Autowired
	private ChoiceMapper choiceMapper;
	
	@Autowired
	private CalendarMapper calendarMapper;
	
	@Override
	public String insertChoice(Choice choice) throws Exception {
		choiceMapper.insertChoice(choice);
		
		CreateCalendarRequestDTO calendarDTO = new CreateCalendarRequestDTO();
		calendarDTO.setChoice_id(choice.getChoice_id());
		calendarDTO.setUser_id(choice.getUser_id());
		calendarDTO.setPlant_id(choice.getPlant_id());
		
		calendarMapper.insertCalendar(calendarDTO);
		
		return choice.getChoice_id();
	}

	@Override
	public int stopChoice(String choice_id) throws Exception {
		Calendar calendar = calendarMapper.selectCalendarByChoiceId(choice_id);
		calendarMapper.stopCalendar(calendar.getCalendar_id());
		return choiceMapper.stopChoice(choice_id);
	}
}
