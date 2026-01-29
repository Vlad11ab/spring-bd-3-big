package com.example.springbd3big.enrolment.dtos;

import lombok.Builder;

@Builder
public record EnrolmentCreateRequest(

        Long studentId,
        Long courseId

){}
