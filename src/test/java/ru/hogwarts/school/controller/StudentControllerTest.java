package ru.hogwarts.school.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.srvice.StudentService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentControllerTest {

    StudentService studentService = new StudentService();

    @BeforeEach
    void setUp() {
        Student student1 = new Student(0L, "Алексей", 18);
        studentService.createStudent(student1);
        Student student2 = new Student(0L, "Григорий", 20);
        studentService.createStudent(student2);
        Student student3 = new Student(0L, "Евгений", 19);
        studentService.createStudent(student3);
        Student student4 = new Student(0L, "Владислав", 18);
        studentService.createStudent(student4);
        Student student5 = new Student(0L, "Станислав", 18);
        studentService.createStudent(student5);
    }

    @Test
    void createStudent() {
        Student student = new Student(0L, "Павел", 18);
        studentService.createStudent(student);
        assertEquals(student, studentService.searchStudent(student.getId()));
        assertEquals(studentService.getAllStudents().size(), 6);
    }

    @Test
    void deleteStudent() {
        assertEquals(studentService.getAllStudents().size(), 5);
        studentService.deleteStudent(1L);
        assertEquals(studentService.getAllStudents().size(), 4);
    }

    @Test
    void updateStudent() {
        Student student = new Student(0L, "Павел1", 18);
        studentService.updateStudent(1L, student);
        assertEquals(student.getName(), "Павел1");
        assertEquals(student.getAge(), 18);
    }

    @Test
    void searchStudent() {
        Student student = studentService.searchStudent(2L);
        assertEquals(student.getName(), "Григорий");
        assertEquals(student.getAge(), 20);
    }

    @Test
    void getAllStudent() {
        Collection<Student> collection = studentService.getAllStudents();
        assertEquals(collection.size(), 5);
    }

    @Test
    void getStudentsByAge() {
        Collection<Student> collection = studentService.getStudentsByAge(18);
        assertEquals(collection.size(), 3);
    }

}