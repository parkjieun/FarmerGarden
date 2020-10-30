package com.ssafy.IoTBackend.security.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ssafy.IoTBackend.model.User;
import com.ssafy.IoTBackend.security.service.OAuthService;
import com.ssafy.IoTBackend.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping ("/oauth")
@Slf4j
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Api(value = "OAUTH")
public class OAuthController {
	@Autowired
	private OAuthService oAuthService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@ApiOperation(value="oauth  로그인",response=String.class)
	@PostMapping("/{platform}")
	@ResponseBody ResponseEntity<String> authGoogle(@RequestHeader String accessToken,@PathVariable String platform) throws Exception{
		LocalDateTime time = LocalDateTime.now();
		
		HashMap<String, String> account = oAuthService.getSocialIdByOAuth(accessToken, platform);
		String socialId = account.get("socialId");
		int isOlder = oAuthService.isOlder(accessToken,platform);
		HashMap<String, String> result = new HashMap<String, String>();
		
		//System.out.println(">>>>>>>>>>>>socialId "+socialId);
		
		if(isOlder>0) {
			System.out.println("회원잇음");
			result.put("accessToken", jwtUtil.createToken(oAuthService.getId(socialId)));
		}
		else {
			//false==회원가입
			String userId = DigestUtils.md5DigestAsHex((time.toString()+socialId).getBytes()).toLowerCase();
			result.put("accessToken", jwtUtil.createToken(userId));
			result.put("socialId", socialId);
			result.put("userName", account.get("user_name"));
		}
		
		result.put("isOlder", ""+isOlder);
		
		Gson gson = new Gson();
		return new ResponseEntity(gson.toJson(result),HttpStatus.OK);
	}
	
	@ApiOperation(value = "테스트")
	@GetMapping("/test")
	public ResponseEntity<String> doBuy(User dto) throws Exception {
		System.out.println("--------------------------------------:");
		return new ResponseEntity<String>("succes2", HttpStatus.OK);
	}
	
}