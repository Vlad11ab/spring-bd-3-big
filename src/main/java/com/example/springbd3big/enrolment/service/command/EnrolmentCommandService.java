package com.example.springbd3big.enrolment.service.command;

import com.example.springbd3big.enrolment.dtos.EnrolmentCreateRequest;
import com.example.springbd3big.enrolment.dtos.EnrolmentResponse;

public interface EnrolmentCommandService {

        EnrolmentResponse enrollStudent(EnrolmentCreateRequest req);
}
