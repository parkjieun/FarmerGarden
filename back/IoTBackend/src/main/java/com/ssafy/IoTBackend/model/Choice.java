package com.ssafy.IoTBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
	private String choice_id;
	private String user_id;
	private String plant_id;
	private Boolean grow_flag;
}
