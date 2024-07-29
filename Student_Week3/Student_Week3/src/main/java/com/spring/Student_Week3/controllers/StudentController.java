package com.spring.Student_Week3.controllers;

import com.spring.Student_Week3.entities.Student;
import com.spring.Student_Week3.services.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;


    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);

    }
}
