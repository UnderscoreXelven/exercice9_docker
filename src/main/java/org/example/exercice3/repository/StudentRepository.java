package org.example.exercice3.repository;

import org.example.exercice3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findByName(String name);
}
