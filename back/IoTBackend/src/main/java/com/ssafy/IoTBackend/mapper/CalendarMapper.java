package com.ssafy.IoTBackend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.calendar.Calendar;
import com.ssafy.IoTBackend.model.calendar.CreateCalendarRequestDTO;

@Repository
@Mapper
public interface CalendarMapper {
	
	public int insertCalendar(CreateCalendarRequestDTO calendarDTO) throws Exception;
	
	public List<Calendar> selectCalendar(String user_id) throws Exception;
	
	public int stopCalendar(Integer calendar_id) throws Exception;
	
	public Calendar selectCalendarByChoiceId(String choice_id) throws Exception;

	public Calendar selectEntireCalendarByChoiceId(String choice_id) throws Exception;
	
}
