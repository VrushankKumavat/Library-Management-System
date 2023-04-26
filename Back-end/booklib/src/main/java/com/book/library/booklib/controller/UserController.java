package com.book.library.booklib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.booklib.dao.UserRepository;
import com.book.library.booklib.dto.UsersDTO;
import com.book.library.booklib.model.Users;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{userName}")
	public ResponseEntity<UsersDTO> getUserByName(@PathVariable String userName) {
		Users user =  userRepository.findByUserName(userName);
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUserId(user.getUserId());
		usersDTO.setName(user.getName());
		usersDTO.setUserName(user.getUserName());
		usersDTO.setPassword(user.getPassword());
		return new ResponseEntity<>(usersDTO,HttpStatus.OK);
	}

}
