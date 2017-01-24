package de.uos.rt.exercise._8.obj;

import AlgoTools.IO;

public class Shelf {

	private Book[] books;
	
	public Shelf() {
		books = new Book[0];
	}
	
	public void addBook(Book book) {
		expandShelf(book);
	}
	
	private void expandShelf(Book book) {
		Book[] newBooks = new Book[books.length + 1];
		for(int i = 0; i < books.length; i++) {
			newBooks[i] = books[i];
		}
		newBooks[newBooks.length - 1] = book;
		books = newBooks;
	}
	
	public void print() {
		for(int i = 0; i < books.length; i++) {
			IO.println(books[i]);
		}
	}
	
}


