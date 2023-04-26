package com.book.library.booklib.dto;

import java.util.Date;

public class BookDTO {
	
	private long id;
	private String title;
	private String author;
	private Date publicationDate;
	private String isbn;
	private int numOfPages;
	public BookDTO(long id, String title, String author, Date publicationDate, String isbn, int numOfPages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbn = isbn;
		this.numOfPages = numOfPages;
	}
	
	public BookDTO() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	

}
