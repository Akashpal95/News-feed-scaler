package com.scaler.newsfeed.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scaler.newsfeed.controllers.UserrController;
import com.scaler.newsfeed.dtos.LoginUserRequestDTO;
import com.scaler.newsfeed.dtos.LoginUserResponseDTO;

@Component
public class LoginUserCommand implements Command{
    private UserrController userrController;

    @Autowired
    public LoginUserCommand(UserrController userrController){
        this.userrController = userrController;
    }

    // login_user email password
    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("login_user")){
            return false;
        }
        return  true;
    }

    @Override
    public void execute(String input) {
       List<String> params = Arrays.stream(input.split(" ")).toList();
       String email = params.get(1);
       String password = params.get(2);

       LoginUserRequestDTO reqDto = new LoginUserRequestDTO();
       reqDto.setPassword(password);
       reqDto.setEmail(email);

       LoginUserResponseDTO responseDTO = userrController.loginUser(reqDto);
       String Session = responseDTO.getSession();
       System.out.println("Logged In : " + Session);
    }
    
}
