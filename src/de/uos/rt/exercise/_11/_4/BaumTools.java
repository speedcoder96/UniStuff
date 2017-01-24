package de.uos.rt.exercise._11._4;
/******************************  BaumTools.java  ******************************/

import AlgoTools.IO;

/**
 * Utility-Klasse mit einigen Algorithemn fuer Baeume
 */
public class BaumTools {

  /**
   * Druckt einen Baum auf der Konsole ebenenweise aus.
   * Nutzt baumTiefe(Baum), printEbene(Baum,int,int) und spaces(int).
   * @param b der zu druckende Baum
   */
  public static void printBaum(Baum b) {

	  //Berechne die Tiefe des Baumes
	  int resttiefe = baumTiefe(b);

	  //Gehe die Ebenen des Baumes durch
	  for(int i = 0; i < resttiefe; i++) {
	  //Drucke die Ebene, beruecksichtige Anzahl der Leerzeichen
	  //fuer korrekte Einrueckung
	      printEbene(b, i, spaces(resttiefe - i));
	      IO.println();
	      IO.println();
	  }

  }

  /**
   * Druckt eine Ebene eines Baumes aehnlich der Breitensuche
   * aus. 0 ist dabei die Wurzel. Vor und nach jedem Element
   * werden spaces Leerzeichen eingefuegt.
   * @param b der auszugebende Baum
   * @param ebene die gewuenschte Ebene beginnend bei 0
   * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
   */
  public static void printEbene(Baum b, int ebene, int spaces) {

    //Wenn 0 erreicht, drucke Element mit Leerzeichen
    if(ebene == 0) {

      IO.print("", spaces);
      if(b != null) {
        IO.print(b.value());
      }
      else { //Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
        IO.print(" ");
      }
      IO.print(" ", spaces + 1);

    } else {

      //Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
      //dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
      //gelaufen.
      if(b != null && !b.left().empty()) {
        printEbene(b.left(), ebene - 1, spaces);
      }
      else {
        printEbene(null, ebene - 1, spaces);
      }

      if(b != null && !b.right().empty()) {
        printEbene(b.right(), ebene - 1, spaces);
      }
      else {
        printEbene(null, ebene - 1, spaces);
      }

    }

  }

  /**
   * Berechnet die Anzahl an benoetigten Leerzeichen fuer
   * eine korrekte Einrueckung, also 0.5 * (2^(ebene) - 2).
   * @param ebene die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
   * @return Anzahl der Leerzeichen zur Elementtrennung
   */
  private static int spaces(int ebene) {

    if(ebene == 1) {
      return 0;
    }
    else {
      //verdoppele die Leerzeichen gegenueber der Ebene darunter
      //und fuege ein weiteres Leerzeichen hinzu
      return 2 * spaces(ebene - 1) + 1;
    }

  }
  
  /**
   * Berechnet die Tiefe des Baumes.
   * @param b der Baum dessen Tiefe bestimmt werden soll
   * @return die Tiefe des Baumes, Anzahl der Ebenen
   */
  public static int baumTiefe(Baum b) {
	  if(b.empty()) {
		  return 0;
	  }
	  int left = baumTiefe(b.left());
	  int right = baumTiefe(b.right());
	  
	  return (left >= right) ? left + 1 : right + 1;
	  
  }

  /**
   * Baut einen Verweisbaum aus einer Inorder <tt> in </tt> und einer
   * Postorder <tt> post </tt>
   * @param in Inorder des zu erzeugenden Baumes
   * @param post Postorder des zu erzeugenden Baumes
   * @return ein eindeutiger Baum erzeugt aus einer In- und Postorder
   * @throws RuntimException wenn der Baum in der In- und Postorder keine
   * Wurzel definiert hat
   */
  public static VerweisBaum inorderPostorderBau(int[] in, int[] post) {
	  
	  if(in.length != 0 && post.length != 0) {
		  //Wurzel
		  int root = post[post.length - 1];
		  
		  //Finde den Index von der Wurzel
		  int rootIndex = 0;
		  for(; rootIndex < in.length && in[rootIndex] != root; rootIndex++);
		  
		  //Wenn keine Wurzel gefunden wurde
		  if(rootIndex == in.length) {
			  throw new RuntimeException("Baum hat keine Wurzel");
		  }
		  
		  //Linker und rechter Teil der In- und Postorder
		  int[] inLeft = new int[rootIndex];
		  int[] postLeft = new int[inLeft.length];
		  int[] inRight = new int[in.length - rootIndex - 1];
		  int[] postRight = new int[inRight.length];
		  
		  for(int i = 0; i < rootIndex; i++) {
			  inLeft[i] = in[i];
			  postLeft[i] = post[i];
		  }
		  
		  for(int i = rootIndex + 1; i < in.length; i++) {
			  int j = i - (rootIndex + 1);
			  inRight[j] = in[i];
			  postRight[j] = post[rootIndex + j];
		  }
		  
		  //Erzeuge Baum aus rekursiven Aufrufen
		  return new VerweisBaum(
				  inorderPostorderBau(inLeft, postLeft),
				  root,
				  inorderPostorderBau(inRight, postRight));
		  
	  } else {
		  return new VerweisBaum();
	  }

  }

  /**
   * Berechnet ob ein Baum <tt> b </tt> vollstaendig ist.
   * Dies ist der Fall wenn jeder Knoten jeder Ebene keinen
   * oder zwei Soehne besitzt
   * @param b der zu ueberpruefende Baum
   * @return true wenn vollstaendig, sonst false
   */
  public static boolean istVollstaendig(Baum b) {
	  if(b == null) {
		  return false;
	  } else if(b.empty()) {
		  return true;
	  } else {
		  return (baumTiefe(b.left()) == baumTiefe(b.right())) && istVollstaendig(b.right());
	  }
  }

  /**
   * Berechnet die Anzahl der Knoten eines Baumes <tt> b </tt>.
   * @param b der Baum
   * @return die Anzahl der Knoten im Baum
   */
  public static int anzahlKnoten(Baum b) {
	  if(b == null) {
		  return 0;
	  } else if(b.empty()) {
		  return 0;
	  } else {
		  return 1 + anzahlKnoten(b.left()) + anzahlKnoten(b.right());
	  }
  }
 
}
