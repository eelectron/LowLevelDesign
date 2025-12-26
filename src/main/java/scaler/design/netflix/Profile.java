package scaler.design.netflix;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile extends BaseModel{
    private String name;
    
    @ManyToOne()
    private ProfileType profileType;
}
