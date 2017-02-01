package de.uos.rt.exercise._13._5;

import java.util.LinkedList;
import java.util.List;

/**
 * Die Klasse Vertex beschreibt einen Knoten in einem
 * Graphen. Jeder Knoten kann sich mit einem anderen
 * Knoten ueber die Distanz vergleichen 
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 *
 */
public class Vertex implements Comparable<Vertex> {

	/**
	 * Name des Knoten
	 */
	public String name;
	
	/**
	 * Kanten des Knoten
	 */
	public List<Edge> edges;
	
	/**
	 * Nummer des Knoten
	 */
	public int nr;
	
	/**
	 * Anzahl der eigehenden Verbindungen des Knoten
	 */
	public int indegree;
	
	/**
	 * Distanz
	 */
	public double dist;
	
	/**
	 * Status ob der Knoten bereits besucht wurde
	 */
	public boolean seen;
	
	/**
	 * Vorgaenger Knoten dieses Knotens
	 */
	public Vertex prev;
	
	/**
	 * Konstruktor des Knotens
	 * @param name Name des Knotens
	 */
	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}
	
	/**
	 * Ueberprueft ob die Knoten Instanz zu
	 * einer anderen Knoten Instanz <tt> other </tt>
	 * eine Kante hat
	 * @param other die andere Knoten Instanz
	 * @return 
	 */
	public boolean hasEdge(Vertex other) {
		for(Edge e : edges) {
			if(e.dest == other) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vergleicht diese Instanz mit einer anderen
	 * Instanz auf Groesser-Kleiner Beziehung
	 * @param other die andere Knoten Instanz
	 * @return -1 wenn diese Instanz kleiner, +1 wenn groesser
	 * und 0 wenn gleich gross
	 */
	public int compareTo(Vertex other) {
		if(other.dist > dist) {
			return -1;
		} else if(other.dist < dist) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
