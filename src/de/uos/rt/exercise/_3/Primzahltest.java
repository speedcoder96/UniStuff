package de.uos.rt.exercise._3;

import AlgoTools.IO;

public class Primzahltest {

	public static void main(String[] args) {
		
		int inputNumber;
		boolean prim = true;
		
		//Eingabe einer positiven Ganzzahl
		do {
			inputNumber = IO.readInt("Geben Sie eine Zahl ein, um sie zu testen : ");
		} while(inputNumber <= 0);
		
		//Direkter Auschluss bei n = 1
		if(inputNumber == 1) {
			prim = false;
		}
		
		//Naiver Test. Es werden alle Zahlen von 2 bis 
		//n-1 durchlaufen und getestet ob die eingegebene
		//Zahl durch die jeweilige Zahl teilbar ist
		for(int i = 2; (i < inputNumber && prim); i++) {
			if(inputNumber % i == 0) {
				prim = false;
			}
		}
		
		//Ausgabe des Ergebnisses
		if(prim) {
			IO.println(inputNumber + " ist eine Primzahl");
		} else {
			IO.println(inputNumber + " ist keine Primzahl");
		}
		
		
	}
	
	
}
