package de.uos.rt.exercise._4;
/*****************************************************************************/
import AlgoTools.IO;

public class FliesskommaAutomat {

	public static void main(String[] args) {
		
		//Zeilenumbruchszeichen
		final char LINE_FEED_CHAR = '\n';
		
		boolean finished = false;
		//Eingabealphabet
		char[][] inputAlphabet = {{'V','v'},{'Z','z'},{'K','k'}};
		//Startzustand
		int currentState = 0;
		//Ueberfuehrungsfunktion delta
		int[][] delta = {{1,2,5},{5,2,5},{5,2,3},{5,4,5},{5,4,5},{5,5,5}};
		
		do {
			//Eingabe eines Zeichens
			char inputChar = IO.readChar("Geben Sie Zeichen ein : ");
			boolean validChar = false;
			int deltaColumnIndex = 0; 
			
			//Ueberpruefung ob eingegebenes Zeichen Element
			//aus dem Eingabealphabet ist und finden des 
			//Spaltenindex fuer Ueberfuehrungsfunktion
			for(int i = 0; i < inputAlphabet.length; i++) {
				for(int j = 0; j < inputAlphabet[i].length; j++) {
					if(inputAlphabet[i][j] == inputChar) {
						deltaColumnIndex = i;
						validChar = true;
						break;
					}
				}
			}
			
			//Setzen des neuen Zustands mit Hilfe des aktuellen Zustands
			//und dem Spaltenindex des eingegebenen Zeichens aus dem Eingabe-
			//alphabets. Bei Enter Programm beenden.
			if(validChar) {
				currentState = delta[currentState][deltaColumnIndex];
			} else {
				if(inputChar == LINE_FEED_CHAR) {
					finished = true;
				}
			}
			
			//Ausgabe der Akzeptanz der Fliesskommazahl 
			//beim erreichtem Endzustand
			if(currentState == 2 || currentState == 4) {
				IO.println("Fliesskommazahl akzeptiert!");
			} else {
				IO.println("Fliesskommazahl nicht akzeptiert!");
			}
			
		} while(!finished);
	}
}
