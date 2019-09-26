package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.dao.StudentDao;
import com.lin.model.Student;
import com.lin.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public boolean addStudent(Student student){
        return studentDao.addStudent(student);
    }

    public boolean delStudent(int studentId){
        return studentDao.delStudent(studentId);
    }

    public boolean updateStudent(Student student){
        return studentDao.updateStudent(student);
    }

    public Student findById(int studentId){
        return studentDao.findById(studentId);
    }

    public PageInfo<Student> findStudentList(int page, int size){
        PageHelper.startPage(page, size);
        List list = studentDao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }
}
