package com.ADJT.fase1.demo.entity.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetUserDto{
    Long id;
    String name;
    String username;
    String password;
    String lastname;
    String email;
    Date createAt;

}
