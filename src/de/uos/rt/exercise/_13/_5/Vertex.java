package de.uos.rt.exercise._13._5;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	public String name;
	public List<Edge> edges;
	public int nr;
	public int indegree;
	public double dist;
	public boolean seen;
	public Vertex prev;
	
	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}
	
	public boolean hasEdge(Vertex w) {
		for(Edge e : edges) {
			if(e.dest == w) {
				return true;
			}
		}
		return false;
	}

	@Override
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
