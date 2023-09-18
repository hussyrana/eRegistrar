package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.entity.Student;

import java.util.Collection;

public interface StudentService {
    Collection<Student> findAll(String search);

    Student findStudentById(long studentId);

    void addStudent(Student student);

    void deleteStudent(long studentId);

    void updateStudent(Student student);
}
