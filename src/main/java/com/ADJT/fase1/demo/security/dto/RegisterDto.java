package com.ADJT.fase1.demo.security.dto;

import com.ADJT.fase1.demo.security.annotation.UsernameValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @UsernameValidator
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
}
