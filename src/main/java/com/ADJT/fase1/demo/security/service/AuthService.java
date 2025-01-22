package com.ADJT.fase1.demo.security.service;

import java.io.IOException;

import com.ADJT.fase1.demo.security.dto.AuthDto;
import com.ADJT.fase1.demo.security.dto.LoginDto;
import com.ADJT.fase1.demo.security.dto.RegisterDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthDto login(LoginDto dto);

    AuthDto register(RegisterDto dto);

    void refreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException;

    boolean isUsernameValid(String username);
}
