package com.integrationtesting.practice.demo.util;

import java.security.SecureRandom;

public class StringUtils {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String randomString(int length){
        var sr = new SecureRandom();
        var sb = new StringBuilder();
        for(int i=0;i<=length-1;i++){
            int idx = sr.nextInt(CHARACTERS.length());
            char c = CHARACTERS.charAt(idx);
            sb.append(c);
        }
        return sb.toString();
    }
}
