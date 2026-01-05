package curs_managment.controller;

import curs_managment.entity.Course;
import curs_managment.service.CurseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/courses")
public class courseController {

    private final CurseService curseService;

    public courseController(CurseService curseService) {
        this.curseService = curseService;
    }

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course) {
        return curseService.addCourse(course);
    }

    @GetMapping()
    public List<Course> getAllCourses() {
        return curseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return curseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        curseService.deleteCourse(id);
    }

    @PutMapping("/{courseId}/assign-teacher/{teacherId}")
    public Course assignTeacherToCourse(@PathVariable Long courseId, @PathVariable Long teacherId) {
        return curseService.assignTeacherToCourse(courseId, teacherId);
    }

    @PutMapping("/{courseId}/assign-department/{departmentId}")
    public Course assignDepartmentToCourse(@PathVariable Long courseId, @PathVariable Long departmentId) {
        return curseService.assignDepartmentToCourse(courseId, departmentId);
    }
}
