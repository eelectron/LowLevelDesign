package scaler.design.studentExamCourse;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentCourseExam extends BaseModel{
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private ExamCourse examCourse;
    
    private int marks;
}
