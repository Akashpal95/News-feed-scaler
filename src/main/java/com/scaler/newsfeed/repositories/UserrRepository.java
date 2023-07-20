package com.scaler.newsfeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.newsfeed.models.Userr;
import java.util.List;


@Repository
public interface UserrRepository extends JpaRepository<Userr, Long> {
    Userr save(Userr user);
    List<Userr> findByEmail(String email);
}
