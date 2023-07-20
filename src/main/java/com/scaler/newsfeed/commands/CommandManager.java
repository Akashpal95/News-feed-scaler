package com.scaler.newsfeed.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandManager {
    private List<Command> commands = new ArrayList<>();
    
    @Autowired
    public CommandManager(RegisterUserCommand registerUserCommand, LoginUserCommand loginUserCommand){
        commands.add(registerUserCommand);
        commands.add(loginUserCommand);
    }

    public void execute(String input){
        for(Command cmd: commands){
            if(cmd.canExecute(input)){
                cmd.execute(input);
            }
        }
    }
}
