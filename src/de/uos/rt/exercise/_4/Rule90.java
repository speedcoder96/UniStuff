package de.uos.rt.exercise._4;
/*****************************************************************************/
import AlgoTools.IO;

public class Rule90 {

	public static void main(String[] args) {
		
		int t;
		boolean[] cellStates;
		
		//Abfrage der Anzahl der auszugebenen Zeitpunkte
		do {
			t = IO.readInt("Geben Sie an fuer wie viele Zeitpunkte "
					+ "berechnet werden soll?");
		} while(t <= 0);
		
		//Abfrage der einzelnen Stadien fuer jede Zelle
		int[] inputCellStates = IO.readInts("Geben Sie die Stadien "
				+ "der einzelnen Zellen an : ");
		cellStates = new boolean[inputCellStates.length];
		
		//Konvertierung der einzelnen Stadien in boolesche Werte
		for(int i = 0; i < inputCellStates.length; i++) {
			cellStates[i] = inputCellStates[i] > 0;
		}
		
		//Ausgabe der Startstadien jeder einzelnen Zelle zu
		//Zeitpunkt t = 0
		IO.print("Zeitpunkt 0 : ");
		for(int j = 0; j < cellStates.length; j++) {
			char stateChar = (cellStates[j]) ? '@' : '.';
			IO.print(stateChar + " | ", 4);
		}
		IO.println("");
		
		//Ausgabe der Stadien jeder einzelnen Zelle zu 
		//Zeitpunkt 1 bis t. Eine Zelle lebt im naechsten
		//Zeitpunkt weiter, wenn exakt einer ihrer Nachbarn 
		//im vorherigen Zeitpunkt gelebt hat.
		for(int ct = 1; ct <= t; ct++) {
			//Berechnung der einzelnen Zellstadien zum Zeitpunkt ct
			boolean[] nextCellStates = new boolean[cellStates.length];
			for(int i = 0; i < cellStates.length; i++) {
				int prevCell = (i == 0) ? cellStates.length - 1 : i - 1;
				int nextCell = (i == cellStates.length - 1) ? 0 : i + 1;
				nextCellStates[i] = 
						(cellStates[prevCell] ^ cellStates[nextCell]);
			}
			cellStates = nextCellStates;
			
			//Ausgabe der einzelnen Zellstadien zum Zeitpunkt ct
			IO.print("Zeitpunkt " + ct + " : ");
			for(int j = 0; j < cellStates.length; j++) {
				char stateChar = (cellStates[j]) ? '@' : '.';
				IO.print(stateChar + " | ", 4);
			}
			IO.println();
			
		}
		
	}
	
	
}
