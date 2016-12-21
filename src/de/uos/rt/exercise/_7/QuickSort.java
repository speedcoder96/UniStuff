package de.uos.rt.exercise._7;

import AlgoTools.IO;

public class QuickSort {
	
	public static int steps;

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
     * Sortiert das Array <tt>array</tt> nach dem
     * QuickSort-Verfahren.
     * @param array das zu sortierende Array
     */
    public static void sort(int[] array) {
    	quickSort(array, 0, array.length - 1);
    }
    
    /**
     * Sortiert das Array <tt>array</tt> nach dem QuickSort-Verfahren
     * zwischen der unteren Grenze <tt>bottomBorder</tt> und der oberen
     * Grenze <tt>topBorder</tt>
     * 
     * @param array das zu sortierende Array
     * @param bottomBorder die obere Grenze
     * @param topBorder die untere Grenze
     */
    private static void quickSort(int[] array, int bottomBorder, int topBorder) {
    	int temp;
    	
    	//berechnet den mittleren Index
    	int middle = (topBorder + bottomBorder) / 2;
    	
    	//das mittlere Element zum Vergleichen
    	int pivot = array[middle];
    	
    	//untere und obere Grenze als Indices
    	int i = bottomBorder;
    	int j = topBorder;
    	
    	do {
    		//solange das i-te Element kleiner als das Pivot-Element ist,
    		//gehe einen Index in i weiter
    		while(array[i] < pivot) {
    			i++;
    		}
    		//solange das j-te Element groesser als das Pivot-Element ist, 
    		//gehe einen Index in j zurueck
    		while(array[j] > pivot) {
    			j--;
    		}
    		
    		//solange sich die beiden Indices nicht ueberkreuzt haben,
    		//tauschen wir die Elemente an der Position i und j und
    		//erhoehen den Index i um eins und erniedrigen j um 1 
    		if(i <= j) {
    			temp = array[i];
    			array[i] = array[j];
    			array[j] = temp;
    			i++;
    			j--;
    			steps++;
    		}
    	  //solange sich die Indices nicht ueberkreuzt haben
    	} while(i <= j);
    	
    	//sortiere die untere Haelfte 
    	if(bottomBorder < j) {
    		quickSort(array, bottomBorder, j);
    	}
    	
    	//sortiere die oberer Haelfte
    	if(i < topBorder) {
    		quickSort(array, i, topBorder);
    	}
    	
    }
	
}
