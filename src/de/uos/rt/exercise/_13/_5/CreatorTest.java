package de.uos.rt.exercise._13._5;

public class CreatorTest {
	
	public static void main(String[] args) {
		
		double[][] m = {
				{0, 8, 2, Double.MAX_VALUE},
				{Double.MAX_VALUE, 0, Double.MAX_VALUE, 4},
				{Double.MAX_VALUE, 1, 0, 6},
				{Double.MAX_VALUE, 2, Double.MAX_VALUE, 0}
		};
		
		Graph g = GraphCreator.graphFromAdjazenzmatrix(m);
		GraphIO.printGraph(g);
		
	}

}
