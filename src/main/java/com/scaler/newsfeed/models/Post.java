package com.scaler.newsfeed.models;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Post extends BaseModel {
    @ManyToOne
    private Userr userr;
    private String message;
    private Integer upvote;
    private Integer downvote;

    @OneToMany(mappedBy = "post")
    List <Comment> comments;
}
