package de.uos.rt.exercise._9;

import AlgoTools.IO;

public class ShapeTest {

	public static void main(String[] args) {
		
		//TODO ShapeTest Shape
		Shape shapeA = new Shape();
		Shape shapeB = new Shape("gelb", 2, 2, 2);
		
		Sphere sphereA = new Sphere("orange", 0, 0, 0, 4);
		Sphere sphereB = new Sphere("gruen", 4, 4, 4, 6);
		
		Cube cubeA = new Cube("blau", 6, 6, 6, 6);
		Cube cubeB = new Cube("lila", 4, 4, 4, 4);
		
		//ShapeA durch Defaultkonstruktor, ist demnach im 
		//Koordinatenursprung positioniert und hat die Farbe
		//Schwarz
		IO.println("Shape A : ");
		IO.println(shapeA);
		IO.println("Flaeche von Shape A : " + shapeA.getArea());
		IO.println("Volumen von Shape A : " + shapeA.getVolume());
		
		
		//ShapeB Tests
		IO.println("Shape B : ");
		IO.println(shapeB);
		IO.println("Flaeche von Shape B : " + shapeB.getArea());
		IO.println("Volumen von Shape B : " + shapeB.getVolume());
		
		//SphereA Tests
		IO.println("Sphere A : ");
		IO.println(sphereA);
		IO.println("Flaeche von Sphere A : " + sphereA.getArea());
		IO.println("Volumen von Sphere A : " + sphereA.getVolume());
		
		//SphereB Tests
		IO.println("Sphere B : ");
		IO.println(sphereB);
		IO.println("Flaeche von Sphere B : " + sphereB.getArea());
		IO.println("Volumen von Sphere B : " + sphereB.getVolume());
		
		//CubeA Tests
		IO.println("Cube A : ");
		IO.println(cubeA);
		IO.println("Flaeche von Cube A : " + cubeA.getArea());
		IO.println("Volumen von Cube A : " + cubeA.getVolume());
		
		//CubeB Tests
		IO.println("Cube B : ");
		IO.println(cubeB);
		IO.println("Flaeche von Cube B : " + cubeB.getArea());
		IO.println("Volumen von Cube B : " + cubeB.getVolume());
		
		//getDistanceTo Tests
		IO.println("Distanzen zu Koerpern");
		IO.println("Distanz von ShapeA zu ShapeB : " + shapeA.getDistanceTo(shapeB));
		IO.println("Distanz von SphereA zu SphereB : " + sphereA.getDistanceTo(sphereB));
		IO.println("Distanz von CubeA zu CubeB : " + cubeA.getDistanceTo(cubeB));
		IO.println("Distanz von SphereA zu CubeB : " + sphereA.getDistanceTo(cubeB));
		IO.println("Distanz von CubeA zu ShapeB : " + cubeA.getDistanceTo(shapeB));
		
		
		
	}
	
}
