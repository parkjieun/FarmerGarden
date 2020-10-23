package com.ssafy.IoTBackend.util;

public abstract interface Encrypter {
    public static final int saltLength = 10;

    String encrypt(String plain);

    boolean check(String plain, String hashed);
}
