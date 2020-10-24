package com.ssafy.IoTBackend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.calendar.Calendar;

@Repository
@Mapper
public interface CalendarMapper {
	
	List<Calendar> selectCalendar(String user_id) throws Exception;
}
