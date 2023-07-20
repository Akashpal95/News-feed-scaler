package com.scaler.newsfeed.exceptions;

public class PasswordDoesNotMatchException extends Exception {
    public PasswordDoesNotMatchException(String message){
        super(message);
    }
}
