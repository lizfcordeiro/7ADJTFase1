package com.ADJT.fase1.demo.entity.dto;

import com.ADJT.fase1.demo.util.Constant;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PutUserDto {
    @NotBlank(message = "{name.notblank}")
    @Size(min = 2, max=26, message="{name.size}")
    @Pattern(regexp = "^[^\\s.,0-9\"']+$", message = "{name.invalid}")
    String name;
    @NotBlank(message = "{password.notblank}")
    @Size(min = 8, max=15, message="{password.size}")
    String password;
    @NotBlank(message = "{lastname.notblank}")
    @Size(min = 3, max=26, message="{lastname.size")
    @Pattern(regexp = "^[^\\s.,0-9\"']+$", message = "{name.invalid}")
    String lastname;
    @NotEmpty(message = "{email.notempty}")
    @Email(message = "{email.notformat}",  regexp = Constant.EMAIL_REGEXP)
    String email;
}
