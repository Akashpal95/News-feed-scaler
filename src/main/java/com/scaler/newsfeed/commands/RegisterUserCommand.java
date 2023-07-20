package com.scaler.newsfeed.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.scaler.newsfeed.controllers.UserrController;
import com.scaler.newsfeed.dtos.RegisterUserRequestDTO;
import com.scaler.newsfeed.dtos.RegisterUserResponseDTO;
import com.scaler.newsfeed.models.Userr;

@Component
public class RegisterUserCommand implements Command{

    private UserrController userrController;

    @Autowired
    public RegisterUserCommand(UserrController userrController){
        this.userrController = userrController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("register_user")){
            return false;
        }
        return  true;
    }

    // register_user name phone email password
    @Override
    public void execute(String input) {
    System.out.println("Comming to execute!");
       List<String> params = Arrays.stream(input.split(" ")).toList();
       String name = params.get(1);
       String phone_number = params.get(2);
       String email = params.get(3);
       String password = params.get(4);

       RegisterUserRequestDTO reqDto = new RegisterUserRequestDTO();
       reqDto.setEmail(email);
       reqDto.setPassword(password);
       reqDto.setPhone_number(phone_number);
       reqDto.setUsername(name);
       
       RegisterUserResponseDTO responseDTO = userrController.registerUser(reqDto);
       Userr userr = responseDTO.getUserr();
       System.out.println("Registered : " + userr);

    }
    
}
//register_user Akash 988 email pass
//login_user email1 pass