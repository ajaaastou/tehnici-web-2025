package curs_managment.controller;

import curs_managment.entity.Teacher;
import curs_managment.service.teacherService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teachers")
public class teacherController {

    private final teacherService teacherService;

    public teacherController(teacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public java.util.List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

}
