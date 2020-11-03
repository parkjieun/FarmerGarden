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
	public int insertCalendar(CreateCalendarRequestDTO calendarDTO) throws Exception {
		return calendarMapper.insertCalendar(calendarDTO);
	}
	
	@Override
	public List<Calendar> selectCalendar(String user_id) throws Exception {
		return calendarMapper.selectCalendar(user_id);
	}

	@Override
	public int stopCalendar(Integer calendar_id) throws Exception {
		return calendarMapper.stopCalendar(calendar_id);
	}

}
