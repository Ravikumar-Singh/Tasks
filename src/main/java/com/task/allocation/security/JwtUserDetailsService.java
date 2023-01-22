package com.task.allocation.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.allocation.repo.UserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.task.allocation.model.User userData=	userrepo.findByUserName(username);
		if (userData==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		
			
			
		} else {
			return new User(userData.getUserName(), userData.getPassword(),
					new ArrayList<>());
		}
	}

}