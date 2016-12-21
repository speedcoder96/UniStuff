package de.uos.rt.exercise._8;

import AlgoTools.IO;

public class BookDataObj {

	public static void main(String[] args) {
		
		Shelf shelf = new Shelf();
		
		 do {
		      IO.println("Bitte geben Sie Buchdaten ein.");
		      String title = IO.readString("Bitte den Titel eingeben: ");
		      String author = IO.readString("Bitte den Autor eingeben: ");
		      int releaseYear = IO.readInt("Bitte das Erscheinungsjahr"
		      		+ " eingeben: ");

		      shelf.addBook(new Book(title, author, releaseYear));

	    } while(IO.readInt("Moechten Sie weitere Buecher eingeben? "
	    		+ " Abbruch mit 0: ") != 0);
		
		shelf.print();
		
	}
	
}
