package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private long studentId = 0;

    public Student addStudent(Student student) {
        student.setId(++studentId);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return studentMap.remove(id);
    }
}