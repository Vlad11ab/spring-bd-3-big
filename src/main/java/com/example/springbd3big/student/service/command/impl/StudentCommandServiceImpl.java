package com.example.springbd3big.student.service.command.impl;

import com.example.springbd3big.enrolment.model.Enrolment;
import com.example.springbd3big.student.dtos.StudentCreateRequest;
import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.mappers.StudentMapper;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import com.example.springbd3big.student.service.command.StudentCommandService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse createStudent(StudentCreateRequest req) {
        Student savedStudent = studentRepository.save(studentMapper.toEntity(req));

        return studentMapper.toDto(savedStudent);
    }


}
