package com.spring.pet.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.pet.entity.Appointment;
import com.spring.pet.repository.AppointmentRepository;


@Service
public class AppointmentService  {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	public void save(Appointment app)
	{
		
		appointmentRepository.save(app);
	}
	
	
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}


	
}
