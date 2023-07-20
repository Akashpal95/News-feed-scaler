package com.scaler.newsfeed.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.newsfeed.dtos.LoginUserRequestDTO;
import com.scaler.newsfeed.dtos.LoginUserResponseDTO;
import com.scaler.newsfeed.dtos.RegisterUserRequestDTO;
import com.scaler.newsfeed.dtos.RegisterUserResponseDTO;
import com.scaler.newsfeed.dtos.ResponseStatus;
import com.scaler.newsfeed.dtos.StatusCode;
import com.scaler.newsfeed.exceptions.PasswordDoesNotMatchException;
import com.scaler.newsfeed.models.Userr;
import com.scaler.newsfeed.services.SessionService;
import com.scaler.newsfeed.services.UserrService;

@Controller
public class UserrController {
    
    @Autowired
    private UserrService userrService;

    @Autowired
    private SessionService sessionService;

    
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO requestDTO){
        RegisterUserResponseDTO responseDTO;
        try{
            Userr userr = userrService.createUser(requestDTO.getUsername(), requestDTO.getPhone_number(), requestDTO.getEmail(), requestDTO.getPassword());
           responseDTO = new RegisterUserResponseDTO(userr, StatusCode.SUCCESS, "Registration Successfull");
        }catch(Exception e){
            System.out.println(e);
            responseDTO =  new RegisterUserResponseDTO(null, StatusCode.FAILURE, e.getMessage());
        }
        
        return responseDTO;
    }

    public LoginUserResponseDTO loginUser(LoginUserRequestDTO requestDTO){
        LoginUserResponseDTO responseDTO;
        try{
            //Check if user exists
            Userr userr = userrService.findUserByEmail(requestDTO.getEmail());
            
            //match password
            if(!userr.getEncrypted_password().equals(requestDTO.getPassword())){
                throw new PasswordDoesNotMatchException("Password doesn't match");
            }
            
            //create unique session token
            String sessionToken = sessionService.generateSessionToken();
            sessionService.setUserSession(userr, sessionToken);
            responseDTO =  new LoginUserResponseDTO(new ResponseStatus(StatusCode.SUCCESS, "Login Successfull"), sessionToken);
        }catch(Exception e){
            System.out.println(e);
            responseDTO =  new LoginUserResponseDTO(new ResponseStatus(StatusCode.FAILURE, e.getMessage()), null);
        }
        
        return responseDTO;
    }
}
