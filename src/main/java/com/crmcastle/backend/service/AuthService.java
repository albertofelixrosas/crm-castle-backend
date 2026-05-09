package com.crmcastle.backend.service;

import com.crmcastle.backend.dto.auth.AuthResponse;
import com.crmcastle.backend.dto.auth.LoginRequest;
import com.crmcastle.backend.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
