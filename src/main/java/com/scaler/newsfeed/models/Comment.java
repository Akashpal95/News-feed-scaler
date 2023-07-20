package com.scaler.newsfeed.models;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Comment extends BaseModel {
    @ManyToOne
    private Userr userr;
    
    @ManyToOne
    private Post post;

    private String message;
    private Integer upvote;
    private Integer downvote;

}
