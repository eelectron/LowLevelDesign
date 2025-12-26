package scaler.design.netflix;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfileVideo extends BaseModel{
    @ManyToOne()
    VideoStatus videoStatus;
    
    @ManyToOne()
    Profile profile;
    
    @ManyToOne()
    Video video;
    
    @LastModifiedDate
    Date lastWatch;
}
