package com.lin.controller;

import com.github.pagehelper.PageInfo;
import com.lin.model.Student;
import com.lin.service.StudentService;
import com.lin.validator.StudentValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students",studentList);
        return "allStudent";
    }
    @RequestMapping("toAddStudent")
    public String toAddStudent(){
        return "addStudent";
    }
    @RequestMapping("/addStudent")
    public String addStudent(@Validated Student student, BindingResult result, Model model) {
        if (result.hasErrors()){
            Map<String,String> err = new HashMap<String, String>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for ( FieldError fieldError: fieldErrors) {
                err.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("errors", err);
            return "addStudent";
        }
        studentService.addStudent(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/del/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.delStudent(studentId);
        return "redirect:/student/list";
    }

    @RequestMapping("toUpdateStudent")
    public String toUpdateStudent(Model model, @RequestParam(value = "id")Integer studentId){
        model.addAttribute("student", studentService.findById(studentId));
        return "updateStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Model model,Student student){
        studentService.updateStudent(student);
        student = studentService.findById(student.getStudentId());
        model.addAttribute("student", student);
        return "redirect:/student/list";
    }
    //分页显示
    @GetMapping(value = {"/list","/",""})
    public String pageStudentList(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                  Model model){

        //默认每页记录
        PageInfo<Student> pageInfo = studentService.findStudentList(page, size);
        model.addAttribute("pageInfo", pageInfo);
        return  "listStudentPage";
    }
}
