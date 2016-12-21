package de.uos.rt.exercise._5;

import AlgoTools.IO;

/**
 * 
 * @author Tim Adam und Rene Sommerfeld
 *
 */
public class Rekursion {
	
	//Eingabeoptionen im Menue zur Auswahl der Methode
	static final char[] INPUT_OPTIONS = {'a', 'b', 'c'};
	
	//definiert eine Option, die nicht in der Auswahl vorhanden ist
	static final char INVALID_OPTION = 'E';	

	/**
	 * Diese Methode ruft die richtige ackermann-Funktion
	 * auf, nachdem die angegebenen Parameter geprueft wurden. 
	 *
	 * @param n Parameter n der Ackermann-Funktion
	 * @param m Parameter m der Ackermann-Funktion
	 * @return liefert das Ergebnis der Ackermann-Funktion
	 * von n und m wieder
	 * @throws RuntimeException wenn einer der Parameter n 
	 * und m negativ ist
	 */
	public static int ackermann(int n, int m) {
		if(n < 0 || m < 0) {
			throw new RuntimeException("Bitte positive Werte fuer n und m");
		} else {
			return ack(n, m);
		}
	}
	
	/**
	 * Die Methode berechnet den Wert
	 * fuer die Parameter m und n nach der rekursiv 
	 * definierten Funktion von Ackermann.
	 * 	 * 
	 * @param n Parameter n der Ackermann-Funktion
	 * @param m Parameter m der Ackermann-Funktion
	 * @return liefert das Ergebnis der Ackermann-Funktion
	 * von n und m wieder
	 */
	private static int ack(int n, int m) {
		if(n == 0) {
			return m + 1;
		} else if(m == 0) {
			return ack(n - 1, 1);
		} else {
			return ack(n - 1, ack(n, m - 1));
		}
	}
	
	/**
	 * Die Methode testet das uebergebene char-Array
	 * auf ein Palindrom. Sprich ein Wort was sowohl
	 * vorwaerts als auch rueckwaerts gelesen, das 
	 * selbe Wort ergibt. 
	 * 
	 * @param word das zu testende Wort als char-Array
	 * @return true, wenn es sich um ein Palindrom handelt,
	 * false wenn nicht
	 */
	public static boolean istPalindrom(char[] word) {
		
		int leftIndex = 0;
		int rightIndex = word.length - 1;
		
		if(leftIndex >= rightIndex) {
			return true;
		} else if(word[leftIndex] != word[rightIndex]) {
			return false;
		} else {
			char[] subWord = new char[word.length - 2];
			for(int i = 1; i < word.length - 1; i++) {
				subWord[i - 1] = word[i];
			}
			return istPalindrom(subWord);
		}
	
	}
	
	/**
	 * Die Methode ueberprueft die Eingabe der 
	 * einzelnen Parameter auf ihre Werte und ruft,
	 * wenn die Parameter der Definition entsprechen
	 * die Methode pot auf in der die Potenz berechnet wird.
	 * 
	 * @param basis die Basis der Potenz
	 * @param exponent der Exponent der Potenz
	 * @return der Wert der Potenz
	 */
	public static double potenz(double basis, int exponent) {
		if(basis == 0 && exponent != 0) {
			throw new RuntimeException("Basis darf nicht Null sein");
		}
		return pot(basis, exponent);
	}

	/**
	 * Die Methode berechnet die Potenz aus der angegebenen
	 * Basis und dem angegebenen Exponenten. Der Exponent
	 * darf sowohl positiv als auch negativ sein.
	 * 
	 * @param basis die Basis der zu berechnenden Potenz
	 * @param exponent der Exponent der zu berechnenden Potenz
	 * @return die berechnete Potenz aus Basis hoch Exponenten
	 */
	private static double pot(double basis, int exponent) {
		if(exponent == 0) {
			return 1;
		} else if(exponent < 0) {
			return 1 / potenz(basis, -exponent);
		}
		return basis * potenz(basis, exponent - 1);
	}
	
	/**
	 * Gibt die einzelnen Optionen zum Waehlen der Methoden
	 * aus
	 */
	public static void printOptions() {
		IO.println("Selektieren Sie eine der folgenden Optionen : ");
		IO.println("a - Ackermann");
		IO.println("b - Palindrom");
		IO.println("c - Potenz");
	}
	
	/**
	 * Gibt an, ob es sich um den uebergebenen Parameter
	 * um eine der moeglichen Eingabeoptionen handelt.
	 * 
	 * @param option die zu ueberpruefende Funktion
	 * @return die ausgewaehlte Option wenn diese in der 
	 * Auswahl vorhanden ist, ansonsten die Konstante 
	 * INVALID_OPTION
	 */
	public static char isValidInputOption(char option) {
		for(int i = 0; i < INPUT_OPTIONS.length; i++) {
			if(INPUT_OPTIONS[i] == option) {
				return option;
			}
		}
		return INVALID_OPTION;
	}
	
	public static void main(String[] args) {
		
		//Selektion einer Option aus den moeglichen Optionen
		char selectedOption = INVALID_OPTION;
		do {
			printOptions();
			selectedOption = isValidInputOption(IO.readChar("Eingabe : "));
		} while(selectedOption == INVALID_OPTION);
		
		//Einlesen der Parameter fuer die ausgewaehlte Option
		//und Ausgabe der Rueckgabe unter Angaben der einzelnen
		//eingegebenen Parameter
		switch(selectedOption) {
			case 'a':
				int[] params = new int[2];
				for(int i = 0; i < params.length; i++) {
					do {
						params[i] = IO.readInt("Geben Sie " + (i + 1) 
								+ ". Integer-Parameter ein : ");
					} while(params[i] < 0);
				}
				IO.print("Ergebnis von ackermann(" + params[0] + ", " 
						+ params[1] + ") = " + 
						ack(params[0], params[1]));
				break;
			case 'b':
				char[] word;
				do {
					word = IO.readChars("Bitte Wort eingeben : ");
				} while(word.length == 0);
				IO.print("Ergebnis von istPalindrom(");
				for(int i = 0; i < word.length; i++) {
					IO.print(word[i]);
				}
				IO.print(") = " + 
						((istPalindrom(word)) 
						? " ist ein Palindrom (true)" 
						: " ist kein Palindrom (false)"));
				break;
			case 'c':
				double basis = 0;
				int exponent = 0;
				do {
					basis = IO.readDouble("Geben Sie eine Basis ein : ");
					exponent = IO.readInt("Geben Sie einen Exponenten ein : ");
				} while(basis == 0 && exponent == 0);
				IO.print("Ergebnis von potenz(" 
						+ basis + ", " + exponent + ") = " 
						+ potenz(basis, exponent));
				break;
			default: 
				break;
		}
		
	}
	
}
