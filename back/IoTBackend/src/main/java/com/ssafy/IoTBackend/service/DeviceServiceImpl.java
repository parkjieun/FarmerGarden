package com.ssafy.IoTBackend.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.IoTBackend.mapper.DeviceMapper;
import com.ssafy.IoTBackend.model.Device;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceMapper mapper;

	@Override
	public Device selectDevice(String user_id) throws Exception {
		return mapper.selectDevice(user_id);
	}

	@Override
	public int insertDevice(Device dto) throws Exception {
		dto.setDevice_id(toHash(dto.getDevice_id()));
		return mapper.insertDevice(dto);
	}

	@Override
	public int updateDevice(Device dto) throws Exception {
		dto.setDevice_id(toHash(dto.getDevice_id()));
		return mapper.updateDevice(dto);
	}
	
	String toHash(String str) throws NoSuchAlgorithmException {
		//MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
		MessageDigest sh = MessageDigest.getInstance("MD5");
		sh.update(str.getBytes()); 
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer(); 
		for(int i = 0 ; i < byteData.length ; i++){
			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		}
		
		return sb.toString();
	}

}
