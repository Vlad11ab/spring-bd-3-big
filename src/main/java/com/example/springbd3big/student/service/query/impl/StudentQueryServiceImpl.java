package com.example.springbd3big.student.service.query.impl;

import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.exceptions.StudentNotFoundException;
import com.example.springbd3big.student.mappers.StudentMapper;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import com.example.springbd3big.student.service.query.StudentQueryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentQueryServiceImpl implements StudentQueryService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentQueryServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;

//        this.getAllStudents();
//        this.getStudentById(1L);
    }
    @Override
    @Transactional
    public List<StudentResponse> getAllStudents() {
        System.out.println("Get All Students:");
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public StudentResponse getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(studentId));

        return studentMapper.toDto(student);
    }

}
