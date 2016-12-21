package de.uos.rt.exercise._3;

import AlgoTools.IO;

public class FloatKodierer {
	
	//definiert die Bitlaenge der Mantisse in einer 
	//Float-Zahl
	static final int MANTISSE_BIT_LENGTH = 23;
	
	//definiert die Bitlaenge des Exponenten in einer
	//Float-Zahl
	static final int EXPONENT_BIT_LENGTH = 8;
	

	public static void main(String[] args) {
		
		float inputNumber;
		float normalMantisse = 0;
		
		//Eingabe einer positiven Zahl n
		do {
			inputNumber = IO.readFloat("Geben Sie eine Zahl ein : ");
		} while(inputNumber < 1);
		
		IO.println("Floating Point Representation : ");
		
		//Berechnung der Potenz, die genau einmal in 
		//die eingegebene Zahl passt, sodass es sich 
		//bei m um eine normalisierte Mantisse handelt
		//fuer diese muss gelten : 1 <= m < 2
		float totalPower = 1.0f;
		int exp = 0;
		while(totalPower <= inputNumber) {
			totalPower *= 2.0f;
			exp++;
		}
		totalPower /= 2.0f;
		exp--;
		normalMantisse = inputNumber / totalPower;
		
		//Berechnung der reduzierten Mantisse
		//fuer diese muss gelten: f = m - 1
		float reducedMantisse = normalMantisse - 1;
		
		//Vorzeichen-Bit plus Freiraum zwischen Vorzeichen und 
		//Exponenten
		IO.print("0 ");
		
		//Umwandlung des Exponenten vom dezimalen ins binaere
		//Zahlensystem
		for(int currentExp = EXPONENT_BIT_LENGTH - 1; currentExp >= 0; currentExp--) {
			int totalExponentPower = 1;
			for(int currentExpIndex = 0; currentExpIndex < currentExp; currentExpIndex++) {
				totalExponentPower *= 2;
			}
			if(exp >= totalExponentPower) {
				exp -= totalExponentPower;
				IO.print('1');
			} else {
				IO.print('0');
			}
		}
		
		//Freiraum zwischen Exponenten und Mantisse
		IO.print(" ");
		
		//Umwandlung der Mantisse vom dezimalen ins binaere 
		//Zahlensystem
		for(int currentManIndex = 0; currentManIndex < MANTISSE_BIT_LENGTH; currentManIndex++) {
			reducedMantisse *= 2.0f;
			if(reducedMantisse >= 1.0f) {
				reducedMantisse -= 1.0f;
				IO.print('1');
			} else {
				IO.print('0');
			}
		}
		
		
	}
	
}
