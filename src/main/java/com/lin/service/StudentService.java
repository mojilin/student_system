package com.lin.service;

import com.github.pagehelper.PageInfo;
import com.lin.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean addStudent(Student student);
    boolean delStudent(int studentId);
    boolean updateStudent(Student student);
    Student findById(int studentId);
    PageInfo<Student> findStudentList(int page, int size);
}
