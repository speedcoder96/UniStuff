package de.uos.rt.exercise._10._3;
/***************************  VerweisSchlangeTest.java  *********************/

import AlgoTools.IO;
import de.uos.rt.exercise._10.Schlange;

/**
 * Programm zum Testen der Methoden des ADT Schlange. Liest Zeichenketten und
 * reiht sie in eine Schlange ein. Bei Eingabe einer leeren Zeichenkette wird
 * die jeweils vorderste aus der Schlange ausgegeben und entfernt.
 */

public class VerweisSchlangeTest
{

  public static void main(String argv[])
  {

    Schlange schlange = new VerweisSchlange();   // konstruiere leere Schlange

    IO.println("Bitte Schlange Fuellen durch Eingabe eines Wortes, ");
    IO.println("Schlangen-Kopf Entfernen durch Eingabe von RETURN.");

    do
    {
      String eingabe = IO.readString("Input:  ");

      if (eingabe.length() > 0)                  // falls Eingabe != RETURN
        schlange.enq(eingabe);                   // fuege in Schlange ein

      // falls EINGABE == RETURN
      else if (!schlange.empty()){               // sofern Schlange nicht leer
        IO.println("entfernt: " + schlange.front());
        schlange.deq();                          // entferne Frontelement
      }
    }
    while (!schlange.empty());

    IO.println("Schlange ist jetzt leer.");
  }
}
