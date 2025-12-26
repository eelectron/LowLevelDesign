package scaler.design.netflix;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String password;
    
    @OneToMany
    private List<Profile> profiles;
}
