package curs_managment.service;

import curs_managment.repository.courseRepository;
import curs_managment.entity.Course;
import curs_managment.entity.Enrollment;
import curs_managment.entity.Student;
import curs_managment.repository.enrollmentRepository;  
import curs_managment.repository.studentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;

@Service
public class enrollmentService {

    private final enrollmentRepository enrollmentRepository;
    private final studentRepository studentRepository;
    private final courseRepository courseRepository;

    public enrollmentService(enrollmentRepository enrollmentRepository, studentRepository studentRepository, courseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));   

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student); 
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        return enrollmentRepository.save(enrollment);

    }

    public List<curs_managment.entity.Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
