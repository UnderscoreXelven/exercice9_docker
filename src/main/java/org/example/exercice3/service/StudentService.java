package org.example.exercice3.service;

import org.example.exercice3.model.Student;
import org.example.exercice3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByName(String name){
        return studentRepository.findByName(name);
    }
}
