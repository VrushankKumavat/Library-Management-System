package com.book.library.booklib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.library.booklib.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
}
