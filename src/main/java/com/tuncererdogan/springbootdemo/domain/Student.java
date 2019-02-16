package com.tuncererdogan.springbootdemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students", schema = "springboot_demo")
public class Student {
    /**
     * Unique student ID
     */
    @Id
    private Long id;

    /**
     * Student name & surname
     */
    private String name;
}