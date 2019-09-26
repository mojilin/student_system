package com.lin.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    @Range(min = 10000000, max = 99999999, message = "学号必须为8位数字")
    private int studentId;
    @NotBlank(message = "姓名不能为空")
    private String name;
    private String gender;
    @Range(min = 0, max = 150, message = "年龄必须在0~150岁之间")
    private int age;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date birthday;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
