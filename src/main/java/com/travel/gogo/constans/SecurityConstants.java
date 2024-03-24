package com.travel.gogo.constans;

public class SecurityConstants {
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "your_secret_key_here"; // Replace with a strong, random key
    public static final long TOKEN_EXPIRATION_TIME = 864000000; // 10 days in milliseconds
    public static final String AUTHORITIES_CLAIM_KEY = "roles";
}
