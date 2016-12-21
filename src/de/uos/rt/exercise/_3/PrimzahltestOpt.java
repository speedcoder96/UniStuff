package de.uos.rt.exercise._3;

import AlgoTools.IO;

public class PrimzahltestOpt {

public static void main(String[] args) {
		
		int inputNumber;
		boolean prim = true;
		
		//Eingabe einer positiven Ganzzahl
		do {
			inputNumber = IO.readInt("Geben Sie eine Zahl ein : ");
		} while(inputNumber <= 0);
		
		//Direkter Auschluss bei n = 1.
		if(inputNumber == 1) {
			prim = false;
		}
		
		//Optimierte for-Schleife fuer den Test, ob die
		//eingegebene Zahl einer Primzahl. Es sind nur 
		//alle Quadratzahlen bis zu n-1 zu testen
		for(int i = 2; ((i * i) < inputNumber && prim); i++) {
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
