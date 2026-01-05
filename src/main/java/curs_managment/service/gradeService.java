package curs_managment.service;

import curs_managment.entity.Course;
import curs_managment.entity.Grade;
import curs_managment.entity.Student;
import curs_managment.repository.courseRepository;
import curs_managment.repository.gradeRepository;
import curs_managment.repository.studentRepository;
import org.springframework.stereotype.Service;


@Service
public class gradeService {

    private final gradeRepository gradeRepository;
    private final studentRepository studentRepository;
    private final courseRepository courseRepository;


public gradeService(gradeRepository gradeRepository, studentRepository studentRepository, courseRepository courseRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Grade assignGrade(Long studentId, Long courseId, String gradeValue) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setCourse(course);        
        grade.setGradeValue(gradeValue);

        return gradeRepository.save(grade);

    }
}
