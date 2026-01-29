package com.example.springbd3big.config;

import com.example.springbd3big.enrolment.dtos.EnrolmentCreateRequest;
import com.example.springbd3big.enrolment.model.Enrolment;
import com.example.springbd3big.enrolment.repository.EnrolmentRepository;
import com.example.springbd3big.enrolment.service.command.EnrolmentCommandService;
import com.example.springbd3big.student.model.Student;
import com.example.springbd3big.student.repository.StudentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigApp {

    private final EnrolmentCommandService enrolmentCommandService;
    private StudentRepository studentRepository;
    private EnrolmentRepository enrolmentRepository;

    public ConfigApp(StudentRepository studentRepository, EnrolmentRepository enrolmentRepository, EnrolmentCommandService enrolmentCommandService){
        this.studentRepository = studentRepository;
        this.enrolmentRepository = enrolmentRepository;
        this.enrolmentCommandService = enrolmentCommandService;


//        this.testFindAll();
//        this.testFindById();
//        this.testExistsByEmailJPQL();
//        this.testEnrollStudent();
    }

    public void testFindAll(){
        studentRepository.findAll().forEach(System.out::println);
    }

    public void testFindById(){
        System.out.println(studentRepository.findById(1L));
    }

    public void testExistsByEmailJPQL(){
        if(studentRepository.existsByEmailJPQL("maria.ionesc@email.com")){
            System.out.println("Exista");
        } else System.out.println("Nu exista");

    }

    public void testEnrollStudent(){
        EnrolmentCreateRequest testReq = EnrolmentCreateRequest.builder()
                .studentId(5L)
                .courseId(5L)
                .build();
        System.out.println("Enrolment salvat");
        enrolmentCommandService.enrollStudent(testReq);
    }





}
