package com.spring.pet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pet.entity.Appointment;



@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
}