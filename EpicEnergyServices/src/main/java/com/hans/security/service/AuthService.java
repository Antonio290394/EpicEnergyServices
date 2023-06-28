package com.hans.security.service;

import java.util.List;

import com.hans.security.entity.AuthUser;
import com.hans.security.payload.LoginDto;
import com.hans.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    List<AuthUser> getAll();
    
}
