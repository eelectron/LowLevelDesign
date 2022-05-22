package scaler.design.netflix;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfileType extends BaseModel{
    private String name;
}
