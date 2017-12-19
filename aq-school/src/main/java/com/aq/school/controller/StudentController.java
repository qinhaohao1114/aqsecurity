package com.aq.school.controller;

import com.aq.school.model.Student;
import com.aq.school.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Student> queryAll(){


    return studentService.queryAll();

    }
}
