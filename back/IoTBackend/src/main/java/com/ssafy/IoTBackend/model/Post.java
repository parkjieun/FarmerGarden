package com.ssafy.IoTBackend.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private Integer post_id;
	private String post_title; 
	private String post_contents; 
	private String post_img; 
	private String post_create; 
	private Boolean del_flag;
	private String user_id;
}
