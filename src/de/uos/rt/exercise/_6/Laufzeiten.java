package de.uos.rt.exercise._6;
/************************  Laufzeiten.java  *************************/

import AlgoTools.IO;

/**
 * Komplexitaet von Methoden in der O-Notation
 */

public class Laufzeiten {

	//berechnet den Logarithmus von Zahl n zur Basis 2 in log_2 n in Schritten
	//Laufzeitklasse : O(log_2 n)
	//Begruendung: Das z wird in jedem Schleifendurchlauf um einen Zaehler
	//erhoeht und am Ende ausgegeben. Demnach ist das Ergebnis gleich der
	//Laufzeit
 public static int a(int n) {
    int z = 0;

    while (n > 1) {
      n /= 2;
      z++;
    }
    return z;
  }
  
 	//berechnet das Quadrat der Zahl n in n Schritten
 	//Laufzeitklasse: O(n)
 	//Begruendung: Die Schleife mit der Laufvariable i laeuft bis
 	//n, sprich zu der eingegebenen Zahl n. Demnach ist es eine 
 	//lineare Laufzeit.
  public static int b(int n) {
    int i = 0;
    int b = 1;

    while (++i < n) {
      b = b + 2 * i + 1;
    }
    return b;
  }
  
  	//berechnet die Quadratwurzel der Zahl n
  	//Laufzeitklasse: O(sqrt(n))
  	//Begruendung: Die Variable z zaehlt die einzelnen 
  	//Schleifendurchlaeufe mit und wird am Ende ausgegeben.
  	//Somit entspricht z gleich der Laufzeit.
  public static int c(int n) {
    int t = 1, z = 0;

    while (n > 0) {
      n -= t;
      t += 2;
      z++;
    }
    return z;
  }


/**
 * Angenommen die Methoden u, v, und w haben die folgenden Laufzeiten:
 *
 * u(n) berechnet n^2 in n Schritten -> O(n)
 * v(n) berechnet Wurzel(n) in Wurzel(n) Schritten -> O(Wurzel(n))
 * w(n) berechnet log_2(n) in log_2(n) Schritten -> O(log_2(n)
 *
 * Welche Lauzeiten haben in diesem Fall die folgenden Methoden?
 

  public static int d(int n) {
    return u(v(n));
  }
  
  zu Methode d : u(v(n)) Wurzel n + Wurzel n  = 2 * Wurzel n -> O(Wurzel n)

  public static int e(int n) {
    return v(w(n));
  }
  
  zu Methode e : v(w(n)) log_2(n) + log_2(Wurzel(n)) = 
  	log_2(n) + log_2(n^1/2) < log_2(n) + log_2(n) = 2 * log_2(n) -> O(log_2(n))

  public static int f(int n) {
    return v(u(n));
  }
  
  zu Methode f: v(u(n)) n + Wurzel(n) = n + n^1/2 < n + n = 2 * n -> O(n)
  

  public static int g(int n) {
    int z = 0;

    for (int i = 1; i <= v(n); i++)
      z += v(n);

    return z;
  }
  
  zu Methode g : v(n) Wurzel(n) * Wurzel(n) = n -> O(n)
  
  

  public static int h(int n) {
    int z = 0;
    int y = v(n);

    for (int i = 1; i <= y; i++)
      z += v(n);

    return z;
  }
  
  zu Methode h : v(n) Wurzel(n) * Wurzel(n) = n -> O(n)
  

  public static int i(int n) {
    return v(n) + w(n);
  }
  
  Wurzel(n) > log_2(n)
  zu Methode i : v(n) + w(n) Wurzel(n) + log_2(n) < Wurzel(n) + Wurzel(n) = 
  				 2 * Wurzel(n) -> Wurzel(n)

  public static int j(int n) {
    return u(u(n));
  }
  
  zu Methode j: u(u(n)) n + n = 2 * n -> (n)
  
*/


  /** Hauptprogramm */
  public static void main(String argv[]) {
    int n;

    do {
      n = IO.readInt("Eingabe von n: ");
    } while (n < 1);

    IO.print("a(" + n + ") =");
    IO.println(a(n), 8);

    IO.print("b(" + n + ") =");
    IO.println(b(n), 8);

    IO.print("c(" + n + ") =");
    IO.println(c(n), 8);
  }
}
