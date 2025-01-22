package com.ADJT.fase1.demo.security.service;

import com.ADJT.fase1.demo.entity.model.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {

    public String extractUsernameFromToken(String jwt);
    public String getToken(final User users);
    public String getRefreshToken(final User users);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
