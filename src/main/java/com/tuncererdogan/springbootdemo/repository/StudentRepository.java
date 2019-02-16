package com.tuncererdogan.springbootdemo.repository;

import com.tuncererdogan.springbootdemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
