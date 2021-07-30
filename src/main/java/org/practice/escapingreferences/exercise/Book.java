package org.practice.escapingreferences.exercise;

public class Book {
	private final int id;
	private final String title;
	private final String author;
	private Price price;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Book(int id, String title, String author, Double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = new Price(price);
	}


	public Book(Book book) {
		this.id = book.id;
		this.title = book.title;
		this.author = book.author;
		this.price = new Price(book.price);
	}


	public String toString() {
		return title + " by " + author;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = new Price(price);
	}
}
