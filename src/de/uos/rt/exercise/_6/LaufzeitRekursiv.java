package de.uos.rt.exercise._6;
/*************************  LaufzeitRekursiv.java  ***************************/

import AlgoTools.IO;

/**
 *
 * @author Nicolas Neubauer (nineubau@uos.de)
 * @author Sebastian Buescher (sbuesche@uos.de)
 * @author Jana Lehnfeld (jlehnfel@uos.de)
 * @author Nils Haldenwang (nhaldenw@uos.de)
 *
 */
public class LaufzeitRekursiv {

  public static void rek(int n) {

    if(n < 2) {
      IO.print(":-");
    } else {
      rek(n-1);

      for(int i = 0; i < 2*n - 1; i++){
        IO.print(")");
      }
    }

  }

  public static void main(String[] args) {
    int zahl;

    do {
      zahl = IO.readInt("Bitte ein int.");
    } while(zahl < 0);

    rek(zahl);
  }
  
  /*
   * zu Aufgabenteil a : f = { 1, 					falls n < 2
   * 						   2 * n - 1 + f(n - 1) sonst	
   * 
   * 
   * zu Aufgabenteil b : f soll Element von O(n^2) sein
   * 
   * Induktionsanfang: Sei g eine Funktion mit n^2
   * 				   Dann muss f(1) = g(1) sein, damit es in die
   * 				   Laufzeitklasse O(n^2) faellt.
   * 
   *				   f(1) = 1 = g(1) = 1
   *				   f(2) = 2 * 2 - 1 + 1 = 4 
   *				   f(3) = 2 * 3 - 1 + 2 * 2 - 1 + 1 = 9
   *
   * Induktionsvorrausetzung:
   * 				   f(n) = g(n) fuer feste n 
   * 
   * 				   
   * Induktionsschritt:
   * 				   f(n + 1) = (n + 1)^2
   * 				   f(n + 1) = (n + 1)^2
   * 				   f(n + 1) = (n + 1) ^ 2
   * 				   f(n + 1) = n^2 + 2n + 1
   * 				   2 * n - 1 + f(n) = (n + 1)^2 | -2n; -1
   * 				   
   * 					
   * 				   
   * 				 
   * 				 
   */

}
