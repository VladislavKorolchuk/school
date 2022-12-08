package ru.hogwarts.school.srvice;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.reception.StudentNotFoundReception;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private Map<Long, Student> studentMap = new HashMap<>();
    private long count = 0;

    public Student createStudent(Student student) {
        Long createid = ++count;
        student.setId(createid);
        Student newStudent = studentMap.put(createid, student);
        return newStudent;
    }

    public void deleteStudent(Long id) {
        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
        } else {
            throw new StudentNotFoundReception();
        }
    }

    public Student updateStudent(Long id, Student student) {
        if (studentMap.containsKey(id)) {
            Student updateStudent = studentMap.get(id);
            updateStudent.setName(student.getName());
            updateStudent.setAge(student.getAge());
            return student;
        } else {
            throw new StudentNotFoundReception();
        }
    }

    public Student searchStudent(Long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        } else {
            throw new StudentNotFoundReception();
        }

    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public Collection<Student> getStudentsByAge(int age) {
        Collection<Student> students;
        students = studentMap.values().stream().
                filter(a -> a.getAge() == age).
                collect(Collectors.toList());
        return students;
    }

}