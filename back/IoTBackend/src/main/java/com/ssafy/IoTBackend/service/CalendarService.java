package com.ssafy.IoTBackend.service;

import java.util.List;

import com.ssafy.IoTBackend.model.calendar.Calendar;
import com.ssafy.IoTBackend.model.calendar.CreateCalendarRequestDTO;

public interface CalendarService {
	
	public void insertCalendar(CreateCalendarRequestDTO calendarDTO) throws Exception;

	public List<Calendar> selectCalendar(String user_id) throws Exception;

	public void stopCalendar(Integer calendar_id) throws Exception;

}
