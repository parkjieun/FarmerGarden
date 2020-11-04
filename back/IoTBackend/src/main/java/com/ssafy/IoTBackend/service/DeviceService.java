package com.ssafy.IoTBackend.service;

import com.ssafy.IoTBackend.model.Device;

public interface DeviceService {
	
	public int insertDevice(Device dto) throws Exception;
	public Device selectDevice(String user_id) throws Exception;
	public int updateDevice(Device dto) throws Exception;
}
