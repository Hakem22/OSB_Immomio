package com.example.OSB.security;


public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="EEEE234";
    long EXPIRATION=10*24*3600;
}
