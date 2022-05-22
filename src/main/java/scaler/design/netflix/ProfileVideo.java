package scaler.design.netflix;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
