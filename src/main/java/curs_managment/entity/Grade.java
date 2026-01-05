package curs_managment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value =1, message = "Grade must be at least 1")
    @Max(value =10, message = "Grade must be at most 10")
    private String gradeValue;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id")   
    private Course course;

    public Grade() {
    }

    public Grade(String gradeValue, Student student, Course course) {
        this.gradeValue = gradeValue;
        this.student = student;
        this.course = course;
    }

    // Getters and Setters

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGradeValue() {
        return gradeValue;
    }
    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }


}
