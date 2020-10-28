package com.ssafy.IoTBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.CalendarMapper;
import com.ssafy.IoTBackend.model.calendar.Calendar;
import com.ssafy.IoTBackend.model.calendar.CreateCalendarRequestDTO;

@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarMapper calendarMapper;
	
	@Override
	public void insertCalendar(CreateCalendarRequestDTO calendarDTO) throws Exception {
		calendarMapper.insertCalendar(calendarDTO);
	}
	
	@Override
	public List<Calendar> selectCalendar(String user_id) throws Exception {
		return calendarMapper.selectCalendar(user_id);
	}

	@Override
	public void stopCalendar(Integer calendar_id) throws Exception {
		calendarMapper.stopCalendar(calendar_id);
	}

}
