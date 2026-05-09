package com.crmcastle.backend.service.impl;

import com.crmcastle.backend.dto.auth.AuthResponse;
import com.crmcastle.backend.dto.auth.LoginRequest;
import com.crmcastle.backend.dto.auth.RegisterRequest;
import com.crmcastle.backend.entity.AppUser;
import com.crmcastle.backend.entity.UserRole;
import com.crmcastle.backend.exception.ConflictException;
import com.crmcastle.backend.exception.BadRequestException;
import com.crmcastle.backend.repository.UserRepository;
import com.crmcastle.backend.security.JwtService;
import com.crmcastle.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new ConflictException("USER_EMAIL_DUPLICATE", "An account with this email already exists");
        }

        AppUser user = new AppUser();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(UserRole.AGENT);

        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        } catch (BadCredentialsException ex) {
            throw new BadRequestException("INVALID_CREDENTIALS", "Invalid email or password");
        }

        AppUser user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadRequestException("INVALID_CREDENTIALS", "Invalid email or password"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole());
    }
}
