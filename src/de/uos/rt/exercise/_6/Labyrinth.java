package de.uos.rt.exercise._6;

/******************************  Labyrinth.java  ******************************/

/**
 * Liest ein Labyrinth ein und berechnet mittels einem Backtracking
 * Algorithmus einen Weg durch dieses.
 * 
 * @author Christian Heiden
 * @author Lukas Kalbertodt
 */

import AlgoTools.IO;

public class Labyrinth {

	/** Freies Feld */
	private static final char FREI = ' ';
	/** Mauer */
	private static final char MAUER = '#';
	/** Startfeld */
	private static final char START = 'S';
	/** Zielfeld */
	private static final char ZIEL = 'Z';
	/** Besuchtes Feld */
	private static final char PFAD = '-';

	/**
	 * Bewegungsvektoren oben, rechts, unten, links
	 */
	private static final int[][] NEIGHBOUR_CELL_VECTOR_MATRIX = 
			new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
				// rechts oben links unten

	/**
	 * Findet einen Weg durch das Labyrinth. Findet den Startpunkt und ruft
	 * findeZielRek mit dem Startpunkt auf.
	 * 
	 * @param lab Das Labyrinth
	 * @throws RuntimeException Wenn kein Startpunkt gefunden wurde
	 * @return Ob ein Weg gefunden wurde
	 */
	private static boolean findeZiel(char[][] lab) {

		// Initialisierung mit -1 fuer den Fall
		// das kein Startpunkt gefunden wird
		int x = -1, y = -1;

		// sucht linear nach dem Startfeld des
		// Labyrinthes
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				if (lab[i][j] == START) {
					x = j;
					y = i;
					break;
				}
			}
		}

		// kein Startfeld gefunden
		if (x == -1 && y == -1) {
			throw new RuntimeException("Das Labyrinth hat kein Startpunkt");
		}
		// Startfeld gefunden
		return findeZielRek(lab, x, y);
	}

	/**
	 * Findet rekursiv einen Weg durch das Labyrinth
	 * 
	 * @param lab Das Labyrinth
	 * @param x X-Koordinate des Punktes bei dem man steht
	 * @param y Y-Koordinate des Punktes bei dem man steht
	 * @return Ob ein Weg gefunden wurde
	 */
	private static boolean findeZielRek(char[][] lab, int x, int y) {
		
		//Ueberprueft um welchen Feldtyp es sich bei dem aktuell
		//besuchten Feld im Labyrinth handelt
		switch(lab[y][x]) {
			case ZIEL:
				return true;
			case MAUER:
				return false;
			case PFAD:
				return false;
			case START:
				break;
			case FREI:
				//wenn das Feld frei ist, setze Pfad
				lab[y][x] = PFAD;
				break;
		}
		
		for(int i = 0; i < NEIGHBOUR_CELL_VECTOR_MATRIX.length; i++) {
			//y-Position des i-ten Nachbarfeldes
			int neighbourCellY = y + NEIGHBOUR_CELL_VECTOR_MATRIX[i][0];
			//x-Position des i-ten Nachbarfeldes
			int neighbourCellX = x + NEIGHBOUR_CELL_VECTOR_MATRIX[i][1];
			//Ueberprueft ob sich die Position des Nachbarfeldes
			//noch innerhalb der Dimensionen des Labyrinthes
			//befindet
			if(neighbourCellY >= 0 && neighbourCellY < lab.length
					&& neighbourCellX >= 0 && neighbourCellX < lab[0].length) {
				if(findeZielRek(lab, neighbourCellX, neighbourCellY)) {
					return true;
				}
			}
		}
		
		//Wenn es sich bei dem aktuell besuchten Feld nicht um
		//das Startfeld handelt, und bis hier kein Ergebnis
		//zurueckgeliefert wurde, fuehrt das Feld nicht zum Ziel
		//und die Pfadmarkierung geloescht und false returnt
		if(lab[y][x] != START) {
			lab[y][x] = FREI;
		}
		
		return false;
		
	}

	/**
	 * Zeigt das uebergebene Labyrinth auf dem Terminal an
	 * 
	 * @param lab Das anzuzeigende Labyrinth
	 */
	private static void druckeLabyrinth(char[][] lab) {
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				IO.print(lab[i][j]);
			}
			IO.println();
		}
	}

	/**
	 * Liest das Labyrinth vom Terminal ein
	 * 
	 * @return Das eingelesene Labyrinth
	 */
	private static char[][] leseEingabe() {
		int breite = 0, hoehe = 0;

		// Lese Breite ein
		do {
			breite = IO.readInt("Breite des Labyrinths: ");
		} while (breite <= 0);

		// Lese Hoehe ein
		do {
			hoehe = IO.readInt("Hoehe des Labyrinths: ");
		} while (hoehe <= 0);

		// Lege Array an, welches ausgegeben wird
		char[][] out = new char[hoehe][breite];

		// Fuer jede Zeile
		for (int i = 0; i < hoehe; i++) {
			char[] zeile;

			// lies Zeile mit korrekter Anzahl von Buchstaben ein
			do {
				zeile = IO.readChars("Zeile " + (i + 1) + " des Labyrinths: ");
			} while (zeile.length != breite);

			out[i] = zeile;
		}
		return out;
	}

	/**
	 * Liest Labyrinth ein und findet einen Weg von S nach Z
	 */
	public static void main(String[] args) {

		// Lese Labyrinth ein
		char[][] lab = leseEingabe();

		// Gebe aus
		IO.println();
		IO.println("----- Original-Labyrinth: -----");
		druckeLabyrinth(lab);
		IO.println();

		boolean gefunden = findeZiel(lab);

		if (gefunden) {
			// Gebe aus
			IO.println("-----   Gefundener Weg:   -----");
			druckeLabyrinth(lab);
		} else {
			IO.println("Kein Weg zum Ziel gefunden!");
		}
	}
}
