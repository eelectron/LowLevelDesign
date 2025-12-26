package scaler.design.netflix;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actor extends BaseModel{
    private String name;
    
    @ManyToMany()
    private List<Video> videos;
}
