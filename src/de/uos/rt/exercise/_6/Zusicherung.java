package de.uos.rt.exercise._6;
/**************************  Zusicherung.java  *******************************/
import AlgoTools.IO;

/**
 * Beweis der Korrektheit mit Hilfe der Zusicherungsmethode
 */

public class Zusicherung {

  public static void main(String[] args) {

    int i = 0, h = 1, z = 0, n;

    do {
      n = IO.readInt("n= ");
    } while (n < 0);

    /* z = i * i und h = 2 * i + 1 und i <= n ist Schleifeninvariante P */

    while (i < n) {
      //z = i * i und h = 2 * i + 1 und i <= n und i < n Schleifeninvariante P
      //z = i * i und h = 2 * i + 1 und i < n
      z += h; // z = z + h
      //z = i * i + 2 * i + 1 und h = 2 * i + 1 und i < n
      //z = (i + 1) ^ 2 und h = 2 * i + 1 und i < n
      h += 2; // h = h + 2
      //z = (i + 1) ^ 2 und h = 2 * i + 3 und i < n
      i++; // i = i + 1
      //z = (i + 1 - 1)^ 2 und h = 2 * (i - 1) + 3 und i < n
      //z = i^2 und h = 2 * i - 2 + 3 und i < n
      //z = i * i und h = 2 * i + 1 und i < n ist Schleifeninvariante P 
    }
    //z = i * i und h = 2 * i + 1 und i >= n
    IO.println(z, 6);
    
    //zu Aufgabenteil a: Die Methode gibt das Quadrat der Zahl n aus 
    //zu Aufgabenteil b: siehe Kommentare in der Main-Methode
    //zu Aufgabenteil c: Da i immer groeßer wird und am Anfang
    //					 das n nicht kleiner als das i gewaehlt werden kann,
    //					 ist der Abbruch des Programmes gesichert und damit 
    //					 die totale Korrektheit durch die Bedingung in der
    //					 while-Schleife gegeben.
    //zu Aufgabenteil d: Da i jeden Schleifendurchlauf mitzaehlt bis n -> O(n)
    
  }
}
