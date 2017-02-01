package de.uos.rt.exercise._13._5;

/**
 * Test der Klassen Graph, GraphCreator, Vertex und Edge
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 */
public class CreatorTest {
	
	public static void main(String[] args) {
		
		//Adjazenzmatrix des Graphen aus dem Script
		double[][] m = {
				{0, 8, 2, Double.MAX_VALUE},
				{Double.MAX_VALUE, 0, Double.MAX_VALUE, 4},
				{Double.MAX_VALUE, 1, 0, 6},
				{Double.MAX_VALUE, 2, Double.MAX_VALUE, 0}
		};
		
		//Erzeugung des Graphen aus der Adjazenzmatrix
		Graph g = GraphCreator.graphFromAdjazenzmatrix(m);
		
		//Ausgabe des Graphen
		GraphIO.printGraph(g);
		
	}

}
