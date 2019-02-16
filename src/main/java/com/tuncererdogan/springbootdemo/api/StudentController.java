package com.tuncererdogan.springbootdemo.api;

import com.tuncererdogan.springbootdemo.domain.Student;
import com.tuncererdogan.springbootdemo.service.StudentService;
import com.tuncererdogan.springbootdemo.service.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping(value = "/{student_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Student> get(@PathVariable("student_id") Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(
                service.getStudentById(studentId)
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = service.createStudent(student);

        return ResponseEntity.
                created(URI.create("/students/" + createdStudent.getId())).
                body(createdStudent);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<?> updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{studentId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<Long> deleteStudent(@PathVariable Long studentId) throws StudentNotFoundException {
        service.deleteStudent(studentId);

        return ResponseEntity.ok(studentId);
    }
}
