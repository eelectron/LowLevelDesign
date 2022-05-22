package scaler.design.studentExamCourse;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Exam extends BaseModel{
    private int duration;
}
