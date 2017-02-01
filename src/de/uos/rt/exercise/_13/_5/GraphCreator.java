package de.uos.rt.exercise._13._5;

/**
 * Die Klasse GraphCreator ist fuer das Erzeugen
 * von Graphen zustaendig
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 */
public class GraphCreator {

	/**
	 * Erzeugt aus der uebergebenen Adjazenzmatrix <tt> matrix </tt>
	 * einen Graphen.
	 * @param matrix die Adjazenzmatrix die den Graphen beschreibt
	 * @return den erzeugten Graphen
	 */
	public static Graph graphFromAdjazenzmatrix(double[][] matrix) {
		Graph graph = new Graph();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				double cost = matrix[i][j];
				if(!(cost == 0 || cost == Double.MAX_VALUE)) {
					String source = String.valueOf(i);
					String dest = String.valueOf(j);
					graph.addEdge(source, dest, cost);
				}
			}
		}
		return graph;
	}
	
}
