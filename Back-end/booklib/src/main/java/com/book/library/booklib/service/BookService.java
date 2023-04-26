package com.book.library.booklib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.booklib.dao.BookRepository;
import com.book.library.booklib.dto.BookDTO;
import com.book.library.booklib.exceptions.CustException;
import com.book.library.booklib.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookDTO> getAllBooks(){

		List<Book> books = bookRepository.findAll();
		List<BookDTO> bookDTOs = new ArrayList<>();
		
		books.forEach(book -> {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId(book.getId());
			bookDTO.setAuthor(book.getAuthor());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setNumOfPages(book.getNumOfPages());
			bookDTO.setPublicationDate(book.getPublicationDate());
			bookDTO.setTitle(book.getTitle());
			bookDTOs.add(bookDTO);
		});
		return bookDTOs;
	}
	
	public BookDTO getBookById(long id) throws CustException{
		Book book = bookRepository.findById(id).orElseThrow(() -> new CustException("Book with id "+id+" not found"));
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setNumOfPages(book.getNumOfPages());
		bookDTO.setPublicationDate(book.getPublicationDate());
		bookDTO.setTitle(book.getTitle());
		return bookDTO;
	}
	
	public Long addBook(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setAuthor(bookDTO.getAuthor());
		book.setIsbn(bookDTO.getIsbn());
		book.setNumOfPages(bookDTO.getNumOfPages());
		book.setPublicationDate(bookDTO.getPublicationDate());
		book.setTitle(bookDTO.getTitle());
		
		Book book2 =  bookRepository.save(book);
		
		return book2.getId();
	}
	
	public void updateBook(long id, BookDTO bookDTO) throws CustException{
		Book book = bookRepository.findById(id).orElseThrow(() -> new CustException("Book with id "+id+" not found"));
		
		book.setId(bookDTO.getId());
		book.setAuthor(bookDTO.getAuthor());
		book.setIsbn(bookDTO.getIsbn());
		book.setNumOfPages(bookDTO.getNumOfPages());
		book.setPublicationDate(bookDTO.getPublicationDate());
		book.setTitle(bookDTO.getTitle());
		
		 bookRepository.save(book);
	}
	
	public void deleteBook(long id) throws CustException {
		bookRepository.findById(id).orElseThrow(() -> new CustException("Book with id "+id+" not found"));
		bookRepository.deleteById(id);
	}
	
}
