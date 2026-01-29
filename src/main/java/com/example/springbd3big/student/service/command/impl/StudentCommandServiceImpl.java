package com.example.springbd3big.student.service.command.impl;

import com.example.springbd3big.student.dtos.StudentCreateRequest;
import com.example.springbd3big.student.dtos.StudentResponse;
import com.example.springbd3big.student.dtos.StudentUpdateRequest;
import com.example.springbd3big.student.exceptions.StudentNotFoundException;
import com.example.springbd3big.student.mappers.StudentMapper;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import com.example.springbd3big.student.service.command.StudentCommandService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentResponse createStudent(StudentCreateRequest req) {
        Student savedStudent = studentRepository.save(studentMapper.toEntity(req));

        return studentMapper.toDto(savedStudent);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Long studentId, StudentUpdateRequest req) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(studentId));

        student.setEmail("updatedEmail@update.com");
        student.setFirstName("updatedFirstName");
        student.setLastName("updatedLastName");

        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public StudentResponse deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(studentId));

        studentRepository.delete(student);

        return studentMapper.toDto(student);
    }


}
