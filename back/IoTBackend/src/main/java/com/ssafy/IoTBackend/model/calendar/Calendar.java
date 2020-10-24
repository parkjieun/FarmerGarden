package com.ssafy.IoTBackend.model.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
	private Integer calendar_id;
	private String calendar_eat_day; 
	private String calendar_start_day;
	private String calendar_stop_day;
	private Integer choice_id; 
	private String user_id;
	private Integer plant_id;
}
