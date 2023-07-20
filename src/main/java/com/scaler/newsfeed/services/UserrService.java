package com.scaler.newsfeed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.newsfeed.exceptions.UserDoesNotExistException;
import com.scaler.newsfeed.exceptions.UserRegistrationException;
import com.scaler.newsfeed.models.Userr;
import com.scaler.newsfeed.repositories.UserrRepository;

@Service
public class UserrService {
    private UserrRepository userrRepository;

    @Autowired
    public UserrService(UserrRepository userrRepository){
        this.userrRepository = userrRepository;
    }

    public Userr createUser(String name, String phone_number, String email, String password) throws UserRegistrationException{
        System.out.println("Coming to service");
        Userr userr = null;
        try{
        userr = new Userr(name, phone_number, email, password);
        userrRepository.save(userr);
        }catch(Exception e){
            throw new UserRegistrationException("User Registration failed");
        }
        
        return userr;
    }

    public Userr findUserByEmail(String email) throws UserDoesNotExistException{
        System.out.println("Coming to user service findUserByEmail");
        List<Userr> userList =  userrRepository.findByEmail(email);
        if(userList.size() == 0){
            throw new UserDoesNotExistException("User with email " + email + " doesn't exist");
        }
        return userList.get(0);
    }
}
