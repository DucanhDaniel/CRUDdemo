package com.personal.cruddemo.dao;

import com.personal.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    int deleteByLastName(String lastName);

    int deleteAllStudent();

    void deleteById(Integer id);
}