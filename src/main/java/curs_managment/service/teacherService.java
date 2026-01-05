package curs_managment.service;

import curs_managment.entity.Teacher;
import curs_managment.repository.teacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class teacherService {

    private final teacherRepository teacherRepository;

    public teacherService(teacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public java.util.List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

}
