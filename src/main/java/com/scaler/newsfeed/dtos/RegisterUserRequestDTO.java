package com.scaler.newsfeed.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String username;
    private String password;
    private String phone_number;
    private String email;
}
