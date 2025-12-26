package scaler.design.netflix;

import java.util.Date;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfileType extends BaseModel{
    private String name;
}
