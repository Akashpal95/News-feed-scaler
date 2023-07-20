package com.scaler.newsfeed.models;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@AllArgsConstructor
public class Session extends BaseModel {
   private LocalDateTime valid_till;
   private String token; 

   @OneToOne
   private Userr userr;
}
