package com.lin.validator;

import com.lin.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class StudentValidator implements Validator {

    public boolean supports(Class clazz){
        return Student.class.equals(clazz);
    }

    public void validate(Object obj, Errors error){
        ValidationUtils.rejectIfEmpty(error, "name", "name.empty");
        Student student = (Student) obj;
        if(student.getAge() < 0){
            error.rejectValue("age", "年龄不能小于0岁");
        }else if (student.getAge() > 150){
            error.rejectValue("age", "年龄不能大于150岁");
        }
    }

}
