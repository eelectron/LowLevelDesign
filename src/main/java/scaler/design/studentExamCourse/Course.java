package scaler.design.studentExamCourse;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course extends BaseModel{
    private String name;
    
    @ManyToMany
    private List<Student> students;
    
    
}
