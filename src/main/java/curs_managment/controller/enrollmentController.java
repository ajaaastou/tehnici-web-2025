package curs_managment.controller;

import curs_managment.service.enrollmentService;
import curs_managment.entity.Enrollment;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class enrollmentController {

    private final enrollmentService enrollmentService;

    public enrollmentController(enrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enrollStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.enrollStudentInCourse(studentId, courseId);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

}
