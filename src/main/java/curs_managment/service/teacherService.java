package curs_managment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import curs_managment.entity.Teacher;
import curs_managment.repository.teacherRepository;

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

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
