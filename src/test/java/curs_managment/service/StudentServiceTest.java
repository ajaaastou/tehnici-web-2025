package curs_managment.service;

import curs_managment.entity.Student;
import curs_managment.repository.studentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private studentRepository studentRepository;

    @InjectMocks
    private studentService studentService;

    @Test
    public void testGetAllStudents() {

        List<Student> mockStudents = Arrays.asList(
            
                new Student(null,"Astu", "astu@gmail.com", 26),
                new Student(null,"Alex", "alex@gmail.com", 22)
        );

        when(studentRepository.findAll()).thenReturn(mockStudents);

        List<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size());
        assertEquals("Astu", students.get(0).getName());
        assertEquals("Alex", students.get(1).getName());
    }
}