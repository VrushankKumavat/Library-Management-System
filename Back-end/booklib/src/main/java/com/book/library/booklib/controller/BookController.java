package com.book.library.booklib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.booklib.dto.BookDTO;
import com.book.library.booklib.exceptions.CustException;
import com.book.library.booklib.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBooks(){
		List<BookDTO> bookDTOs = bookService.getAllBooks();
		return new ResponseEntity<>(bookDTOs,HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
		Long bookId = bookService.addBook(bookDTO);
		String successMsg = "Sucessfully added book with id "+bookId;
		return new ResponseEntity<>(successMsg,HttpStatus.CREATED);
	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable long id) throws CustException{
		BookDTO bookDTO = bookService.getBookById(id);
		return new ResponseEntity<>(bookDTO,HttpStatus.OK);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<String> updateBook(@PathVariable long id, @RequestBody BookDTO bookDTO) throws CustException{
		bookService.updateBook(id, bookDTO);
		String successMsg = "Sucessfully updated user with id "+id;
		return new ResponseEntity<>(successMsg,HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<List<BookDTO>> deleteBook(@PathVariable long id)throws CustException {
		bookService.deleteBook(id);
		String successMsg = "Sucessfully deleted user with id "+id;
		return getAllBooks(); 
	}

}
