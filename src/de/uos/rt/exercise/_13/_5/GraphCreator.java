package de.uos.rt.exercise._13._5;

public class GraphCreator {

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
