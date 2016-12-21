package de.uos.rt.exercise._8;

public class Book {

	private String title;
	private String author;
	private int releaseYear;
	
	
	public Book(String title, String author, int releaseYear) {
		this.title = title;
		this.author = author;
		this.releaseYear = releaseYear;
	}
	
	public String toString() {
		return title + " [ " + author + " ] (" + releaseYear + ")"; 
	}
	
}
