package com.life.common.util;

public class TokenUtil {
    public static String getToken(String salt){
        String tokenStr = salt+System.currentTimeMillis();
        String token = EnDecryptUtils.md5DigestAsHex((tokenStr).getBytes());
        return token;
    }
}
