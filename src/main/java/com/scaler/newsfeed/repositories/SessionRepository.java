package com.scaler.newsfeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.newsfeed.models.Session;
import java.util.List;


@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session save(Session session);
    List<Session> findByToken(String token); 
}
