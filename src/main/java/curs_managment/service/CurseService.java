package curs_managment.service;

import curs_managment.entity.Course;
import curs_managment.entity.Departement;
import curs_managment.entity.Teacher;
import curs_managment.repository.courseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import curs_managment.repository.departmentRepository;
import curs_managment.repository.teacherRepository;


@Service
public class CurseService {

    private final courseRepository courseRepository;
    private final teacherRepository teacherRepository;    
    private final departmentRepository departmentRepository;
    
    public CurseService(courseRepository courseRepository, teacherRepository teacherRepository, departmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    public Course assignDepartmentToCourse(Long courseId, Long departmentId) {
        Course course = getCourseById(courseId);
        Departement departement = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        course.setDepartement(departement);
        return courseRepository.save(course);
    }
}
