package com.ssafy.IoTBackend.util;

import com.ssafy.IoTBackend.util.BCrypt;
import org.springframework.stereotype.Component;

@Component("encrypter")
public class BCryptEncrypter implements Encrypter {

    @Override
    public String encrypt(String plain) {
	String res = BCrypt.hashpw(plain, BCrypt.gensalt(saltLength));
	
	return res;
    }

    @Override
    public boolean check(String plain, String hashed) {
	try {
	    return BCrypt.checkpw(plain, hashed);
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }

}
