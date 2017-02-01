package de.uos.rt.exercise._13._5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	
	private Map<String, Vertex> vertices;
	
	public Graph() {
		vertices = new HashMap<String, Vertex>();
	}
	
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	public int size() {
		return vertices.size();
	}
	
	public Collection<Vertex> vertices() {
		return vertices.values();
	}
	
	public Vertex getVertex(String name) {
		Vertex vertex = vertices.get(name);
		if(vertex == null) {
			vertex = new Vertex(name);
			vertices.put(name, vertex);
		}
		return vertex;
	}
	
	public void addEdge(String source, String dest, double cost) {
		Vertex sourceVertex = getVertex(source);
		Vertex destVertex = getVertex(dest);
		sourceVertex.edges.add(new Edge(destVertex, cost));
	}

}
