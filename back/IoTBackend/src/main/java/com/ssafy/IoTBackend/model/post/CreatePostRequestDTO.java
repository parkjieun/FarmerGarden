package com.ssafy.IoTBackend.model.post;

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
public class CreatePostRequestDTO {
	
    @ApiModelProperty(required = true)
    @NotBlank(message = "성장일기 제목은 필수 입력값입니다.")
    @Max(125)
    private String post_title;
    
    @ApiModelProperty(required = true)
    @NotBlank(message = "성장일기 내용은 필수 입력값입니다.")
    @Max(65535)
    private String post_contents;
    
    @ApiModelProperty(required = false)
    @Max(255)
	private String post_img;

    @ApiModelProperty(required = true)
    @NotBlank(message = "유저 아이디는 필수 입력값입니다.")
	private String user_id;

}
