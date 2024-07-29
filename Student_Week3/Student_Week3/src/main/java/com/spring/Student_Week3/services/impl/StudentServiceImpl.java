package com.spring.Student_Week3.services.impl;

import com.spring.Student_Week3.entities.Student;
import com.spring.Student_Week3.repositories.StudentRepo;
import com.spring.Student_Week3.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public Student addStudent(Student student){
        return studentRepo.save(student);
    }
}
