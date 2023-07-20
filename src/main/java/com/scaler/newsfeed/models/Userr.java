package com.scaler.newsfeed.models;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Userr extends BaseModel {
    private String name;
    @Column(unique = true)
    private String phone_number;
    @Column(unique = true)
    private String email;
    private String encrypted_password;
    private Date lastLogin;


    public Userr(String name, String phone_number, String email, String password){
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.encrypted_password = password;
    }

    @OneToMany(mappedBy = "userr")
    private List<Post> posts;
    @OneToMany(mappedBy = "userr")
    private List<Comment> comments;

    @ManyToMany
    private Userr follower;

    @Override
    public String toString() {
        return "User{" +
                "username='" + name + '\'' +
                ", hashedPassword='" + encrypted_password + '\'' +
                ", phoneNumber='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    
}
