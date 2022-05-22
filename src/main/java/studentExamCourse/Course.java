package studentExamCourse;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

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
