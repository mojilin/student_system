package com.lin.dao;

import com.lin.model.Student;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findAll();
    boolean addStudent(Student student);
    boolean delStudent(int studentId);
    boolean updateStudent(Student student);
    Student findById(int studentId);

}
