package de.uos.rt.exercise._13._5;

import AlgoTools.IO;

/**
 * Die Klasse GraphIO ist fuer die Ausgaben
 * von Graphen und aehnlichem zustaendig
 */
public class GraphIO {

	public static void printGraph(Graph g) {
		IO.println("Adjazenzlisten des Graphen");
		for(Vertex vertex : g.vertices()) {
			for(Edge edge : vertex.edges) {
				IO.print("(" + vertex.name + "," + edge.dest.name + ") " + edge.cost + " ");
			}
			IO.println();
		}
		IO.println();
	}
	
}


