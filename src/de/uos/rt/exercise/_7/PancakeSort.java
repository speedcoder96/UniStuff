package de.uos.rt.exercise._7;

import AlgoTools.IO;

/**
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 *
 */
public class PancakeSort {

    /**
     * Dreht die Reihenfolge der ersten <tt>count</tt> Elemente im
     * Array <tt>array</tt> um.
     *
     * @param array das zu sortierende Array
     * @param count Anzahl zu flippender Elemente
     *
     * @throws RuntimeException wenn <tt>count</tt> > <tt>array.length</tt>
     */
    public static void flip(int[] array, int count) {
    	if(count > array.length) {
    		throw new RuntimeException("count > array.length");
    	}
    	for(int i = 0; i < count / 2; i++) {
    		int tmp = array[i];
    		array[i] = array[count - i - 1];
    		array[count - i - 1] = tmp;
    	}
    }

    /**
     * Gibt ein Array auf dem Terminal aus.
     *
     * Beispiel: Ein Array mit den Zahlen 1, 2 und 3 als Inhalt
     * wird ausgegeben als: 1 2 3
     *
     * @param array Das auszugebene Array
     */
    public static void printArray(int[] array) {
    	for(int i = 0; i < array.length; i++) {
    		IO.print(array[i] + " ");
    	}
    	IO.println();
    }

    /**
     * Sortiert das gegebene <tt>array</tt> mit dem PancakeSort Verfahren.
     * @param array zu sortierendes Array
     */
    public static void sort(int[] array) {
    	for(int currentSize = array.length; currentSize > 1; currentSize--) {
    		//Position des Maximums aus der aktuellen Betrachtungsgroesse bestimmen
    		int maxIndex = findMaxValueIndex(array, currentSize);
    		//wenn das Maximum nicht am Ende der aktuellen Betrachtungsgroesse ist
    		if(maxIndex != currentSize - 1) {
    			//flippe das Array bis zur Stelle des Maximums (inkl. Maximum)
    			flip(array, maxIndex + 1);
    			//flippe das Array bis zur aktuellen Betrachtungsgroesse
    			flip(array, currentSize);
    		}
    	}
    }
    
    /**
     * Sucht die Position des Maximums aus dem Array <tt>array</tt>
     * mit einer Betrachtungsgroesse <tt>n</tt>
     * @param array das Array aus dem das Maximum gesucht werden soll
     * @param n die Betrachtungsgroesse, Anzahl an Elementen beginnend
     * vom ersten Index des Arrays <tt>array</tt>
     * @return die Position des Maximums aus dem Array <tt>array</tt>
     * bei einer Betrachtungsgroesse <tt>n</tt>
     */
    private static int findMaxValueIndex(int[] array, int n) {
    	int maxIndex = 0;
    	for(int i = 0; i < n; i++) {
    		if(array[maxIndex] < array[i]) {
    			maxIndex = i;
    		}
    	}
    	return maxIndex;
    }

    public static void main(String[] args) {
    	int[] array; 
    	do {
    		array = IO.readInts("Geben Sie eine beliebige Anzahl von "
    				+ "Zahlen ein : ");
    	} while(array.length < 1);
    	IO.println("Array vor dem Sortieren : ");
    	printArray(array);
    	sort(array);
    	IO.println("Array nach dem Sortieren : ");
    	printArray(array);
    	
    }
}
