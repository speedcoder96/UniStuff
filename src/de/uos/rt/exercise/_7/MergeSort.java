package de.uos.rt.exercise._7;

import AlgoTools.IO;

/**
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 *
 */
public class MergeSort {
	
	/**
	 * Anzahl der Arbeitsschritte innerhalb
	 * der Merge-Methode
	 */
	private static int steps;

	/**
	 * Fuegt zwei Arrays <tt>a</tt> und <tt>b</tt>
	 * zu einem einzelnen Array zusammen.
	 * @param a die erste Haelfte 
	 * @param b die zweite Haelfte
	 * @return das zusammengesetzte Array aus 
	 * <tt>a</tt> und <tt>b</tt>
	 */
	private static int[] merge(int[] a, int[] b) {
		int i=0, j=0, k=0;                           
		int[] c = new int[a.length + b.length];      
		
		while ((i < a.length) && (j < b.length)) {  
			if (a[i] < b[j]) {                          
				c[k++] = a[i++];
				steps++;
			}
			else {
				c[k++] = b[j++];
				steps++;
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];  
			steps++;
		}
		while (j < b.length) {
			c[k++] = b[j++];     
			steps++;
		}
		
		return c;                                   
	}
	
	/**
     * Gibt ein Array auf dem Terminal aus
     *
     * @param array Das auszugebene Array
     */
	public static void printArray(int[] array) {
    	for(int i = 0; i < array.length; i++) {
    		IO.print(array[i], 3);
    	}
    	IO.println();
    }

	/**
	 * Sortiert ein Array <tt>array</tt> nach dem
	 * MergeSort-Algorithmus.
	 * @param array das Array das sortiert werden soll
	 * @return das sortierte Array
	 */
	public static int[] recSort(int[] array) {
		//hat das Array nur ein Element,
		//gebe das Array zurueck
		if(array.length == 1) {
			return array;
		}
		
		//spaltet das Array in eine linke und rechte
		//Haelfte auf, bei ungerader Groesse des Arrays
		//ist die linke Haelfte kleiner als die Rechte
		int[] leftArray = new int[array.length / 2];
		int[] rightArray = new int[array.length / 2 + (array.length % 2)];
		for(int i = 0; i < array.length; i++) {
			if(i < leftArray.length) {
				leftArray[i] = array[i];
				steps++;
			} else {
				rightArray[i - leftArray.length] = array[i];
				steps++;
			}
		}
		
		//rufe fuer das linke und das rechte Array
		//die sort-Methode rekursiv auf
		leftArray = recSort(leftArray);
		rightArray = recSort(rightArray);
		
		//fuege die beiden Arrays zusammen und gebe
		//das Ergebnis zurueck
		return merge(leftArray, rightArray);
	}
	
	public static void main(String[] args) {
		int[] array; 
		do {
			array = IO.readInts("Geben Sie eine beliebige Anzahl von "
					+ "Zahlen ein : ");
		} while(array.length < 1);
		printArray(recSort(array));
		IO.print(steps);
	}
	
}
