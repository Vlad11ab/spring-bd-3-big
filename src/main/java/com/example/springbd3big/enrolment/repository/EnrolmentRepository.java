package com.example.springbd3big.enrolment.repository;

import com.example.springbd3big.enrolment.model.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

}
