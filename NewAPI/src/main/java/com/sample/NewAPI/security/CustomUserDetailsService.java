package com.sample.NewAPI.security;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.sample.NewAPI.entity.CustomUserDetails;
import com.sample.NewAPI.entity.Users;
import com.sample.NewAPI.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		
		return new CustomUserDetails(user);
	}

	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if("randomuser123".equals(username)) {
			return new User("randomuser123", 
		            "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}*/

}
