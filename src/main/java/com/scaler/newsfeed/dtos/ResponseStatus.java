package com.scaler.newsfeed.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class ResponseStatus {   
    private StatusCode statusCode;
    private String message;
}
