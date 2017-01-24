package de.uos.rt.exercise._8;

import de.uos.rt.exercise._5.Rekursion;

public class ElfSort {
	
	/**
	 * enthaelt die Anzahl der maximal zu ueberprufenden
	 * Stellen einer Zahl fuer das Sortierverfahren
	 */
	private static final int MAX_DIGIT_VALUE_INDEX = 4;
		
	/**
	 * Sortiert die einzelnen Elemente des Array <tt>presents</tt>
	 * betrachtet auf die Ziffernstelle <tt>currentDigit</tt> nach
	 * dem RadixSort-Verfahren (hier Elfsort) 
	 * 
	 * @param presents das zu sortierende Array
	 * @param currentDigit
	 * @return
	 */
	private static int[] sort(int[] presents, int currentDigit) {
		
		if(currentDigit > MAX_DIGIT_VALUE_INDEX) {
			return presents;
		}
		
		//Ablageflaechen von 0 bis 9
		int[][] shelves = new int[10][0];
		int currentNumberIndex = (int)Rekursion.potenz(10, MAX_DIGIT_VALUE_INDEX - currentDigit);
		
		//Sortieren auf Ablageflaechen betrachtet auf die
		//aktuelle Ziffernstelle
		for(int i = 0; i < presents.length; i++) {
			int presentId = presents[i];
			int shelfIndex = (presentId / currentNumberIndex) % 10;
			shelves[shelfIndex] = putInShelf(shelves[shelfIndex], presentId);
		}
		
		//Sortiert die einzelnen Ablageflaechen nach dem
		//gleichen Verfahren und packt anschliessend die einzelnen
		//Pakete von den Ablageflaechen beginnend bei 0 ended bei 9
		//wieder zurueck in das Array
		int i = 0;
		for(int j = 0; j < shelves.length; j++) {
			if(shelves[j].length > 1) {
				shelves[j] = sort(shelves[j], currentDigit + 1);
			}
			for(int k = 0; k < shelves[j].length; k++) {
				presents[i++] = shelves[j][k];
			}
			
		}
		
		
		
		return presents;
	}
	
	/**
	 * Ruft die eigentliche sort-Methode auf. So
	 * wird verhindert, dass der zweite Parameter willkuerlich
	 * vom Nutzer gewaehlt werden kann
	 * 
	 * @param presents das zu sortierende Array
	 * @return das sortierte Array
	 */
	public static int[] sort(int[] presents) {
		return sort(presents, 0);
	}
	
	/**
	 * Vergroeßert die uebergebene Ablageflaeche <tt>shelf</tt>
	 * um einen weiteren Platz und fuegt das Paket mit der Nummer
	 * <tt>presentId</tt> der erweiterten Ablageflaeche hinzu
	 * 
	 * @param shelf die fuer das Paket bestimmte Ablageflaeche
	 * @param presentId das hinzuzufuegende Paket
	 * @return die erweiterte Ablageflaeche die das hinzuzufuegende
	 * Paket enthaelt
	 */
	private static int[] putInShelf(int[] shelf, int presentId) {
		int[] newShelf = new int[shelf.length + 1];
		for(int i = 0; i < shelf.length; i++) {
			newShelf[i] = shelf[i];
		}
		newShelf[newShelf.length - 1] = presentId;
		return newShelf;
	}
	
	

	

}
