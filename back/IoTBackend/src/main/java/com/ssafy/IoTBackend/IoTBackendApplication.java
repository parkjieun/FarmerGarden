package com.ssafy.IoTBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class IoTBackendApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IoTBackendApplication.class, args);
		
		SpringApplication app = new SpringApplication(IoTBackendApplication.class);
	    app.addListeners(new ApplicationPidFileWriter());  // pid 파일을 생성하는 writer 등록
	    app.run(args);
	}

}
