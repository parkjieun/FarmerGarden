package com.ssafy.IoTBackend.security.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ssafy.IoTBackend.mapper.UserMapper;


@Service
public class OAuthService {
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserMapper mapper;
	
	private final String KAKAO_URL="https://kapi.kakao.com/v2/user/me";
	
	public int isOlder(String accessToken,String platform) throws Exception {	
//		return userRepository.existsBySocialId(getSocialIdByOAuth(accessToken,platform));
		return mapper.existsByUserId(getSocialIdByOAuth(accessToken,platform).get("socialId"));
	}
	
	public HashMap<String,String> getSocialIdByOAuth(String accessToken,String platform) {
		
		ResponseEntity<?> re =null;
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String socialId=null;
		HashMap<String, String> result = new HashMap<String, String>();
		
		if(platform.equals("kakao")) {
			headers.add("Authorization", "Bearer " + accessToken);
			re = rt.exchange(KAKAO_URL,HttpMethod.GET,new HttpEntity<String>(headers),String.class);
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(re.getBody().toString());
			socialId = element.getAsJsonObject().get("id").getAsString();
			result.put("socialId", socialId);
			result.put("user_name", element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString());
		} 
		
		return result;
	}

//	public String getId(String accessToken, String platform) {
//		// TODO Auto-generated method stub
//		return userRepository.findId(getSocialIdByOAuth(accessToken, platform));
//	}
	
	public String getId(String socialId) throws Exception {
		if(socialId==null) return "";
		
		//String id = userRepository.findId(socialId);
		String id = mapper.findId(socialId);
		
		if(id==null) return "";
		
		return id;
	}
}

