package com.scaler.newsfeed.services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.newsfeed.exceptions.SessionDoesNotExistException;
import com.scaler.newsfeed.models.Session;
import com.scaler.newsfeed.models.Userr;
import com.scaler.newsfeed.repositories.SessionRepository;

@Service
public class SessionService {
    
    @Autowired
    private SessionRepository sessionRepository;

    public String generateSessionToken() {
        String sessionToken = UUID.randomUUID().toString();
        return sessionToken;
    }

    public void setUserSession(Userr userr, String sessionToken) {
        LocalDateTime valid_till = LocalDateTime.now().plusHours(1);
        Session session = new Session(valid_till, sessionToken, userr);
        sessionRepository.save(session);
    }

    public Session getUserSession(String sessionToken) throws SessionDoesNotExistException {
        List<Session> sessionList =  sessionRepository.findByToken(sessionToken);
        if(sessionList.size() == 0){
            throw new SessionDoesNotExistException("Session " + sessionToken + " doesn't exist");
        }
        return sessionList.get(0);
    }
}
