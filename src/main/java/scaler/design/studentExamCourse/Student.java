package scaler.design.studentExamCourse;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends BaseModel{
    private String name;
    private String email;
    private String password;
    private String college;
    
    @ManyToMany(mappedBy = "students")
    List<Course> courses;
}
