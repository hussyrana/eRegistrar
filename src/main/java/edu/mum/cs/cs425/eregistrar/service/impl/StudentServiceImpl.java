package edu.mum.cs.cs425.eregistrar.service.impl;

import edu.mum.cs.cs425.eregistrar.entity.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Collection<Student> findAll(String search) {
        if(Objects.isNull(search)){
            return studentRepository.findAll();
        }
        return studentRepository.findAllBySearchString(search);
    }

    @Override
    public Student findStudentById(long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }


    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(Objects.nonNull(student)){
            studentRepository.delete(student);
        }else{
            //todo: will handle all these exceptions via response json
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void updateStudent(Student student) {
        if(Objects.nonNull(studentRepository.findById(student.getStudentId()).orElse(null))){
            studentRepository.save(student);
        }else{
            //todo: will handle all these exceptions via response json
            throw new EntityNotFoundException();
        }
    }
}
