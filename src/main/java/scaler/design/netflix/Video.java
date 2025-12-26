package scaler.design.netflix;

import java.util.Date;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Video extends BaseModel{
    private String title;
    private String description;
}
