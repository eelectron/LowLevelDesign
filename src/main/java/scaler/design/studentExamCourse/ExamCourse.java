package scaler.design.studentExamCourse;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExamCourse extends BaseModel{
    @ManyToOne
    private Exam exam;
    
    @ManyToOne
    private Course course;
    private Date date;
}
