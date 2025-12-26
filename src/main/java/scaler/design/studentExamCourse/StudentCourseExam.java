package scaler.design.studentExamCourse;



import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
