package com.book.library.booklib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.book.library.booklib.dao.UserRepository;
import com.book.library.booklib.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user =  userRepository.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found with username: " + username);
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

}
