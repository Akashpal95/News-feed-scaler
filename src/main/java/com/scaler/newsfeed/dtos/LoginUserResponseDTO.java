package com.scaler.newsfeed.dtos;

import com.scaler.newsfeed.models.Session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUserResponseDTO {
    private ResponseStatus responseStatus;
    private String session;
}
