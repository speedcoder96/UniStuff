package de.uos.rt.exercise._10._4;
/******************************  SuperListeTest.java  **************************/

import AlgoTools.IO;

/**
 * Testet Methoden der Klasse SuperListe.
 */

public class SuperListeTest {

  public static void main (String [] argv) {

    SuperListe l = new SuperListe();

    l.insert(1);
    l.advance();
    l.insert(2);
    l.advance();
    l.insert(2);
    l.advance();
    l.insert(3);
    l.advance();
    l.insert(4);
    l.advance();
    l.insert(5);
    l.advance();
    l.insert(5);

    l.reset();

    System.out.println("Ausgabe");
    while (!l.endpos()) {
      IO.println(l.elem());
      l.advance();
    }

    l.umdrehen();
    IO.println();

    System.out.println("Umgedreht");
    while (!l.endpos()) {
      IO.println(l.elem());
      l.advance();
    }

    l.reset();
    IO.println();
    l.unique();
    System.out.println("Unique");
    while (!l.endpos()) {
      IO.println(l.elem());
      l.advance();
    }

    IO.println("Element an der Stelle 2: "+l.elem(2));
  }
}
