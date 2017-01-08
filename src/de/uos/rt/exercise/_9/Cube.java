package de.uos.rt.exercise._9;

public class Cube extends Shape {
	
	/**
	 * Kantenlaenge des Wuerfels
	 */
	private double width;
	
	/**
	 * Konstruktor des Wuerfels
	 * @param colour die Farbe des Wuerfels
	 * @param x die x Koordinate
	 * @param y die y Koordinate
	 * @param z die z Koordinate
	 * @param width die Kantenlaenge des Wuerfels
	 */
	public Cube(String colour, double x, double y, double z, double width) {
		super(colour, x, y, z);
		setWidth(width);
	}
	
	/**
	 * Setzt die Kantenleange des Wuerfels
	 * @param width die Kantenlaenge
	 */
	public void setWidth(double width) {
		if(width <= 0) {
			throw new RuntimeException("Kantenlaenge darf nicht null oder negativ sein");
		}
		this.width = width;
	}
	
	/**
	 * Gibt die Kantenlaenge des Wuerfels zurueck
	 * @return die Kantenlaenge
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Gibt das Volumen des Wuerfels zurueck
	 * @return das Volumen
	 */
	public double getVolume() {
		return width * width * width;
	}

	/**
	 * Gibt die Oberflaeche des Wuerfels zurueck
	 * @return
	 */
	public double getArea() {
		return width * width * 6;
	}
	
	/**
	 * Gibt den Abstand zwischen einem anderen Koerper
	 * und dieser Wuerfels Instanz zurueck
	 * @return den Abstand zwischen diesem Wuerfel und einem
	 * anderen Koerper
	 */
	public double getDistanceTo(Shape other) {
		if(other instanceof Cube) {
			Cube cube = (Cube)other;
			double diffX = (cube.x + cube.getWidth() / 2) - (x + width / 2);
			double diffY = (cube.y + cube.getWidth() / 2) - (y + width / 2);
			double diffZ = (cube.z + cube.getWidth() / 2) - (z + width / 2);
			return Math.sqrt((diffX * diffX) + (diffY * diffY) + (diffZ * diffZ));
		}
		return super.getDistanceTo(other);
	}
	
	/**
	 * Gibt alle Eigenschaften des Wuerfels als
	 * String Representation zurueck
	 * @return
	 */
	public String toString() {
		return super.toString() + "\nwidth : "+ width;
	}
	
}
