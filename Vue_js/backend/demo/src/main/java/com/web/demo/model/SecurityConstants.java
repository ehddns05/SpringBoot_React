package com.web.demo.model;

public class SecurityConstants {

    //JWT Token을 hash 할 때 사용할 secret key
    public static final String SECRET = "SecretKeyToGenJWTs";
    //JWT Token의 validation 
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    //JWT Token의 prefix는 Bearer 
    public static final String TOKEN_PREFIX = "Bearer ";
    //JWT Token은 Authorization header로 전달
    public static final String HEADER_STRING = "Authorization";
    
    // public static final String SIGN_UP_URL = "/users/sign-up";

}