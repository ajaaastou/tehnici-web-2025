package curs_managment.controller;

import curs_managment.entity.Grade;
import curs_managment.service.gradeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")

public class gradeController {

    private final gradeService gradeService;

    public gradeController(gradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public Grade assignGrade(@RequestParam Long studentId, @RequestParam Long courseId, @RequestParam String gradeValue) {
        return gradeService.assignGrade(studentId, courseId, gradeValue);

    }

    

}
