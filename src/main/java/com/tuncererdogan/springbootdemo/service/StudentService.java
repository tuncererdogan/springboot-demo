package com.tuncererdogan.springbootdemo.service;

import com.tuncererdogan.springbootdemo.domain.Student;
import com.tuncererdogan.springbootdemo.repository.StudentRepository;
import com.tuncererdogan.springbootdemo.service.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student) {
        if (repository.findById(student.getId()).isPresent()) {
            throw new RuntimeException("ID avaiable");
        }

        return repository.saveAndFlush(student);
    }

    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return repository.findById(studentId).
                orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public void updateStudent(Student student) {
        repository.saveAndFlush(student);
    }

    public void deleteStudent(Long studentId) throws StudentNotFoundException {
        if (!repository.findById(studentId).isPresent()) {
            throw new StudentNotFoundException(studentId);
        }

        repository.deleteById(studentId);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }


}
