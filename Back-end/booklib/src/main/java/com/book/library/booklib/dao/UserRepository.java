package com.book.library.booklib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.library.booklib.dto.UsersDTO;
import com.book.library.booklib.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUserName(String username);

}
