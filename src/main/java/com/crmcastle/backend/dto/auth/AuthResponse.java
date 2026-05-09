package com.crmcastle.backend.dto.auth;

import com.crmcastle.backend.entity.UserRole;

public record AuthResponse(
        String token,
        String tokenType,
        Long userId,
        String email,
        String firstName,
        String lastName,
        UserRole role
) {
    public AuthResponse(String token, Long userId, String email, String firstName, String lastName, UserRole role) {
        this(token, "Bearer", userId, email, firstName, lastName, role);
    }
}
