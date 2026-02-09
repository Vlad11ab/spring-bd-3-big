package com.example.springbd3big.enrolment.exceptions;

public class EnrolmentNotFoundException extends RuntimeException {
    public EnrolmentNotFoundException(Long enrolmentId) {
        super("ENROLMENT_NOT_FOUND_EXCEPTION");
    }
}
