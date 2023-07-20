package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Follower extends BaseModel{
    private Userr user;
    private Userr follower;
}
