package de.uos.rt.exercise._13._5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Die Klasse Graph speichert alle angelegten
 * Knoten und deren Kanten in einer Hashmap, um
 * in konstanter Zeit Zugriff auf alle Knoten 
 * haben zu koennen.
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 */
public class Graph {
	/**
	 * Enthaelt alle Knoten des Graphen
	 */
	private Map<String, Vertex> vertices;
	
	public Graph() {
		vertices = new HashMap<String, Vertex>();
	}
	
	/**
	 * Ueberprueft ob der Graph keine Knoten hat
	 * @return true wenn keine Knoten vorhanden, andernfalls false
	 */
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	/**
	 * Gibt die Anzahl der Knoten im Graphen zurueck
	 * @return die Anzahl der Knoten
	 */
	public int size() {
		return vertices.size();
	}
	
	/**
	 * Gibt eine Sammlung aller Knoten aus dem
	 * Graph zurueck
	 * @return alle Knoten
	 */
	public Collection<Vertex> vertices() {
		return vertices.values();
	}
	
	/**
	 * Gibt den Knoten mit dem Namen <tt> name </tt>
	 * aus dem Graphen zurueck. Wenn kein Knoten mit
	 * dem Namen existiert, wird ein Neuer erstellt und
	 * dieser zurueckgeliefert
	 * @param name der Name des zusuchenden Knoten
	 * @return den gefundenen bzw. neuen Knoten
	 */
	public Vertex getVertex(String name) {
		Vertex vertex = vertices.get(name);
		if(vertex == null) {
			vertex = new Vertex(name);
			vertices.put(name, vertex);
		}
		return vertex;
	}
	
	/**
	 * Fuegt im Graph zwischen zwei Knoten eine Kante mit einer
	 * Gewichtung ein
	 * @param source Name des Quellknotens
	 * @param dest Name des Zielknotens
	 * @param cost Kosten der Kante
	 */
	public void addEdge(String source, String dest, double cost) {
		Vertex sourceVertex = getVertex(source);
		Vertex destVertex = getVertex(dest);
		sourceVertex.edges.add(new Edge(destVertex, cost));
	}

}
