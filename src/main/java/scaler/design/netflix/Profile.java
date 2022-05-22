package scaler.design.netflix;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
