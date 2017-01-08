package de.uos.rt.exercise._9;

import AlgoTools.IO;

public class ShapeTest {

	public static void main(String[] args) {
		
		//TODO ShapeTest Shape
		Shape shapeA = new Shape();
		Shape shapeB = new Shape("yellow", 5, 6, 3);
		
		//Test von toString Methode der Shape Klasse
		IO.println(shapeA);
		IO.println(shapeB);
		
		//Test der Methode getDistanceTo
		IO.println("Distanz von A zu B : " +  shapeA.getDistanceTo(shapeB));
		
		//TODO ShapeTest Sphere
		shapeA = new Sphere("orange", 0, 5, 4, 4);
		shapeB = new Sphere("green", 4, 3, 2, 4);
		
		//Test von toString Methode der Sphere Klasse
		IO.println(shapeA);
		IO.println(shapeB);
		
		//Test der Methode getDistanceTo
		IO.println("Distanz von A zu B : " +  shapeA.getDistanceTo(shapeB));
		
		//TODO ShapeTest Cube
		shapeA = new Cube("blue", 6, 6, 6, 6);
		shapeB = new Cube("purple", 4, 3, 2, 10);
		
		//Test von toString Methode der Cube Klasse
		IO.println(shapeA);
		IO.println(shapeB);
		
		//Test der Methode getDistanceTo
		IO.println("Distanz von A zu B : " +  shapeA.getDistanceTo(shapeB));
				
		
		
	}
	
}
