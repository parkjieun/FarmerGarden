package com.ssafy.IoTBackend.model.calendar;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Valid
@Getter
@Setter
@ToString
public class CreateCalendarRequestDTO {
    
    @ApiModelProperty(required = true)
    @NotBlank(message = "선택 아이디는 필수 입력값입니다.")
	private Integer choice_id;
    
    @ApiModelProperty(required = true)
    @NotBlank(message = "유저 아이디는 필수 입력값입니다.")
	private String user_id;
    
    @ApiModelProperty(required = true)
    @NotBlank(message = "식물 아이디는 필수 입력값입니다.")
	private Integer plant_id;
}
