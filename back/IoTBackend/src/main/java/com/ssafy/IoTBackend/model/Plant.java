package com.ssafy.IoTBackend.model;


import lombok.Data;

@Data
public class Plant {
	private String plant_id;
	private String plant_name;
	private String plant_explanation;
	private String plant_eat_days;
	private String plant_steep_hour;
	private String plant_gemmation_hour;
	private String plant_img;
}

