package de.uos.rt.exercise._5;

import AlgoTools.IO;

/**
 * 
 * @author Tim Adam und Rene Sommerfeld
 *
 */
public class Determinante {

	/**
	 * Berechnet die Determinante der uebergebenen 
	 * <tt>matrix</tt>
	 * 
	 * @param matrix die Matrix von der die Determinante
	 * berechnet werden soll
	 * @return den Wert der Determinante
	 */
	private static int determinante(int[][] matrix) {
		if(matrix.length == 1) {
			return matrix[0][0];
		} else {
			int sum = 0;
			for(int j = 0; j < matrix.length; j++) {
				int[][] tempMatrix = new int[matrix.length - 1][matrix.length - 1];
				for(int i = 1; i < matrix.length; i++) {
					for(int k = 0; k < matrix.length; k++) {
						if(k < j) {
							tempMatrix[i - 1][k] = matrix[i][k];
						} else if(k > j) {
							tempMatrix[i - 1][k - 1] = matrix[i][k];
						}
					}
				}
				sum += ((Rekursion.potenz(-1, j + 2)) * matrix[0][j] 
						* determinante(tempMatrix));
			}
			return sum;
		}
		
	}
	
	/**
	 * Diese Methode ueberpruft ob die uebergebene Matrix
	 * quadratisch ist und fuehrt dann die rekursiv definierte
	 * Methode zur Determinantenberechnung aus
	 * @param matrix die Matrix fuer die die Determinante 
	 * berechnet werden soll
	 * @return den Wert der Determinanten
	 */
	public static int det(int[][] matrix) {
		if(matrix.length < 2) {
			throw new RuntimeException("Matrix muss eine "
				+ " Mindestgroesse von 2x2 besitzen");
		}
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i].length != matrix.length) {
				throw new RuntimeException("Matrix muss "
						+ "quadratische Dimension besitzen");
			}
		}
		return determinante(matrix);
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{1,89,4},{1,2,89}};
		
		IO.println(determinante(matrix));
	}
	
}
