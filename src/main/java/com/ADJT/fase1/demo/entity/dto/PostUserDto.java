package com.ADJT.fase1.demo.entity.dto;

import com.ADJT.fase1.demo.util.Constant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostUserDto{
    @NotBlank(message = "{name.notblank}")
    @Size(min = 2, max=26, message="{name.size}")
    String name;
    @NotBlank(message = "{username.notblank}")
    @Size(min = 3, max=15, message="{username.size")
    String username;
    @NotBlank(message = "{password.notblank}")
    @Size(min = 8, max=15, message="{password.size}")
    String password;
    @NotBlank(message = "{lastname.notblank}")
    @Size(min = 3, max=26, message="{lastname.size")
    String lastname;
    @NotEmpty(message = "{email.notempty}")
    @Email(message = "{email.notformat}",  regexp = Constant.EMAIL_REGEXP)
    String email;
}