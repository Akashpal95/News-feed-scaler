package com.scaler.newsfeed.dtos;

import com.scaler.newsfeed.models.Userr;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {
    private Userr userr; 
    private ResponseStatus responseStatus;

    public RegisterUserResponseDTO(Userr userr, StatusCode statusCode, String message){
        this.userr = userr;
        this.responseStatus = new ResponseStatus(statusCode, message);
    }
}
