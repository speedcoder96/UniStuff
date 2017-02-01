package de.uos.rt.exercise._13._5;

/**
 * Die Klasse Edge beschreibt eine Kante
 * in einem Graphen zwischen zwei Knoten.
 * Zusaetzlich werden hier die Kosten hinterlegt
 * die aufgebracht werden muessen, um von Knoten A
 * nach Knoten B zu kommen
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 */
public class Edge {
	/**
	 * Verweis auf den Zielknoten
	 */
	public Vertex dest;
	/**
	 * Kosten der Kante
	 */
	public double cost;
	
	/**
	 * Konstruktor einer Kante
	 * @param dest Zielknoten der Kante
	 * @param cost Kosten der Kante
	 */
	public Edge(Vertex dest, double cost) {
		this.dest = dest;
		this.cost = cost;
	}

}
