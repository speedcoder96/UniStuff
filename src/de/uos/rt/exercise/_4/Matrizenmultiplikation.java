package de.uos.rt.exercise._4;

import AlgoTools.IO;

/**
 * @version 18.11.16
 *  
 * @author  tadam
 * 
 * Berechnet das Kreuzprodukt aus einer Matrix A und einer Matrix B.
 *
 */

public class Matrizenmultiplikation {

  public static void main(String[] argv) {

    int A_zeile, A_spalte, B_spalte;
    //Zeilen und Spalten einlesen
    do {
      A_zeile = IO.readInt("Zeilen Matrix A: ");
    } while (A_zeile <= 0);
    do {
      A_spalte = IO.readInt("Spalten Matrix A: ");
    } while (A_spalte <= 0);
    do {
      B_spalte = IO.readInt("Spalten Matrix B: ");
    } while (B_spalte <= 0);
    int B_zeile = A_spalte;

    int[][]A = new int[A_zeile][A_spalte];
    int[][]B = new int[B_zeile][B_spalte];

    //A einlesen
    IO.println("Matrix A: ");
    for(int zeile = 0; zeile < A.length; zeile++) {
      int z = zeile+1;
      IO.print(z + ". Zeile: ");
      A[zeile] = IO.readInts(A_spalte);
    }

    //B einlesen
    IO.println ("Matrix B: ");
    for (int zeile = 0; zeile < B.length; zeile++) {
      int z = zeile+1;
      IO.print(z + ". Zeile: ");
      B[zeile] = IO.readInts(B_spalte);
    }
    IO.println ();


    //A x B in C berechnen
    int[][]C = new int[A_zeile][B_spalte];

    for (int zeile = 0; zeile < C.length; zeile++) {
      for (int spalte = 0; spalte < C[zeile].length; spalte++) {
        C[zeile][spalte] = 0;
        for (int i = 0; i < A_spalte; i++) {
          C[zeile][spalte] = C[zeile][spalte] + A[zeile][i] * B[i][spalte];
        }
      }
    }
    //Ausgabe Matrix C:
    IO.println(" A x B = "); 
    for (int zeile = 0; zeile < C.length; zeile++) {
      IO.print("(");
      for (int spalte = 0; spalte < C[zeile].length; spalte++){
        IO.print (C[zeile][spalte], 4);
      }
      IO.println (")");
    }
    IO.println ();

  }
}

