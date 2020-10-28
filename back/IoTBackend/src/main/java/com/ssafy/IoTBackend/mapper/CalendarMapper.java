package com.ssafy.IoTBackend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.calendar.Calendar;
import com.ssafy.IoTBackend.model.calendar.CreateCalendarRequestDTO;

@Repository
@Mapper
public interface CalendarMapper {
	
	void insertCalendar(CreateCalendarRequestDTO calendarDTO) throws Exception;
	
	List<Calendar> selectCalendar(String user_id) throws Exception;
	
	void stopCalendar(Integer calendar_id) throws Exception;
}
