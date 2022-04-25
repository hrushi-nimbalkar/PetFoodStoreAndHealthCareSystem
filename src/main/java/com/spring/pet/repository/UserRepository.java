package com.spring.pet.repository;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.spring.pet.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	 Optional<User> findUserByEmail(String email);
	 

	 
	  List<User> findAll();
}
