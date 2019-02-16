package com.tuncererdogan.springbootdemo.service.exception;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(Long studentId) {
        super("Student with id " + studentId + " not found");
    }
}
