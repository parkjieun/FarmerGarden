package com.ssafy.IoTBackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.IoTBackend.model.Device;

@Repository
@Mapper
public interface DeviceMapper {

	public int insertDevice(Device dto) throws Exception;
	
	public Device selectDevice(String user_id) throws Exception;

	public int updateDevice(Device dto);
}

