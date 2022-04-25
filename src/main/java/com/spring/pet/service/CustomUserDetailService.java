package com.spring.pet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.pet.entity.User;
import com.spring.pet.entity.CustomUserDetail;
import com.spring.pet.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findUserByEmail(email); 
		user.orElseThrow(() -> new UsernameNotFoundException ("User to nahi mila"));
	
		return user.map(CustomUserDetail::new).get();
	}
}
