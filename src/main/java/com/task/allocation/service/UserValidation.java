package com.task.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.task.allocation.controller.JwtAuthenticationController;
import com.task.allocation.exceptionhandling.TaskException;
import com.task.allocation.model.JwtRequest;
import com.task.allocation.model.JwtResponse;
import com.task.allocation.model.User;
import com.task.allocation.model.UserResponse;
import com.task.allocation.repo.UserRepo;
import com.task.allocation.security.JwtTokenUtil;

@Service
public class UserValidation {


	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	
	public UserResponse validateUser(JwtRequest request) throws Exception
	{
		User user=	userRepo.findByUserNameAndPassword(request.getUsername(), request.getPassword());
		if(user==null)
		{
			throw new TaskException("user not found");
		}
		
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(request.getUsername());

		 String token = jwtTokenUtil.generateToken(userDetails);
		
		return new UserResponse(user, token);
	}
}
