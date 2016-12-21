package de.uos.rt.exercise._8;
/******************************  BuchDaten.java  ****************************/

import AlgoTools.IO;
import de.uos.rt.exercise._5.Rekursion;

/**
 * Einfacher Algorithmus zur Erfassung von Buchdaten mit Hilfe von
 * char-Arrays
 */

public class BuchDaten {

  /**
  * Erzeugt Buchdaten-Array aus uebergebenen Attributen und
  * haengt diese der als char[][][] Array uebergebenen Liste an.
  *
  * @param titel Vorname des anzulegenden Buchdatums
  * @param autor Nachname des anzulegenden Buchdatums
  * @param erscheinungsjahr Alter des anzulegenden Buchdatums
  * @param liste Array mit bereits vorhandenen Buchdaten
  * @return Kopie der Buchdatenliste ergaenzt um das neue Datum
  * @throws RuntimeException falls Erscheinungsjahr kleiner 0 oder groesser 2012
  */
  public static char[][][] addBuch(char[] titel, char[] autor,
                                   int erscheinungsjahr, char[][][] liste) {
	  
	  if(erscheinungsjahr < 0 || erscheinungsjahr > 2012) {
		  throw new RuntimeException("Erscheinungsjahr im falschen Bereich");
	  }
	  
	  char[][][] newList = new char[liste.length + 1][3][];
	  copyData(newList, liste);
	  newList[newList.length - 1][0] = titel;
	  newList[newList.length - 1][1] = autor;
	  newList[newList.length - 1][2] = intToCharArray(erscheinungsjahr);
	  
	  return newList;
  }
  
  /**
   * Kopiert die Daten aus der alten Liste <tt>oldList</tt> in die neue
   * Liste <tt>newList</tt>.
   * @param newList die neue Liste
   * @param oldList die alte Liste
   */
  private static void copyData(char[][][] newList, char[][][] oldList) {
	  for(int i = 0; i < oldList.length; i++) {
		  for(int j = 0; j < oldList[i].length; i++) {
			  for(int k = 0; k < oldList[i][j].length; k++) {
				  newList[i][j][k] = oldList[i][j][k];
			  }
		  }
	  }
  }
  
  
  /**
   * Wandelt einen Integer <tt>value</tt> in ein
   * Array aus Zeichen um.
   * @param value den umzuwandelden Wert 
   * @return
   */
  private static char[] intToCharArray(int value) {
	  int numDigits = 1;
	  int tempValue = value;
	  
	  //Logarithmus von dem uebergebenen Wert zur Basis 10
	  //um die Anzahl der Ziffern in der Zahl zu bekommen
	  while(tempValue / 10 > 0) {
		  tempValue /= 10;
		  numDigits++;
	  }
	  
	  //Umwandlung der einzelnen Ziffern zu Zeichen
	  char[] digitChars = new char[numDigits];
	  for(int i = 0; i < digitChars.length; i++) {
		  char lastDigitChar = (char)('0' + (value / Rekursion.potenz(10, i)) % 10);
		  digitChars[digitChars.length - i - 1] = lastDigitChar;
	  }
	  
	  return digitChars;
  }

  /**
  * Liesst iteriert Buchendaten ein und gibt die Daten anschliessend
  * auf der Konsole aus.
  */
  public static void main(String[] argv) {
	  
    // Diese Methode soll NICHT geaendert werden.

    char[][][] liste = new char[0][][];

    do {
      IO.println("Bitte geben Sie Buchdaten ein.");
      char[] titel = IO.readChars("Bitte den Titel eingeben: ");
      char[] autor = IO.readChars("Bitte den Autor eingeben: ");
      int erscheinungsjahr = IO.readInt("Bitte das Erscheinungsjahr eingeben: ");

      liste = addBuch(titel, autor, erscheinungsjahr, liste);

    } while(IO.readInt("Moechten Sie weitere Buecher eingeben?"
                          +" Abbruch mit 0: ") != 0);


    for(int i = 0; i < liste.length; i++){
      IO.println("Buch Nr. "+ (i + 1));
      IO.println("Titel: ");
      for(int j = 0; j < liste[i][0].length; j++){
        IO.print(liste[i][0][j]);
      }
      IO.println();
      IO.println("Autor: ");
      for(int j = 0; j < liste[i][1].length; j++){
        IO.print(liste[i][1][j]);
      }
      IO.println();
      IO.println("Erscheinungsjahr: ");
      for(int j = 0; j < liste[i][2].length; j++){
        IO.print(liste[i][2][j]);
      }
      IO.println();
    }
  }
}
