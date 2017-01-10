package de.uos.rt.exercise._9;

/**
 * Diese Klasse beschreibt einen allgemeinen
 * Koerper mit den Koordinaten <tt>x</tt>, 
 * <tt>y</tt> und <tt>z</tt> in einem 
 * dreidimensionalen Raum
 * 
 * @author Rene Sommerfeld
 * @author Tim Adam
 *
 */
public class Shape {

	/**
	 * Farbe des Koerpers
	 */
	public String colour;
	
	/**
	 * Koordinaten des Koerpers
	 */
	public double x, y, z;
	
	/**
	 * Konstruktor des Koerpers
	 * @param colour Farbe des Koerpers
	 * @param x die x Koordinate
	 * @param y die y Koordinate
	 * @param z die z Koordinate
	 */
	public Shape(String colour, double x, double y, double z) {
		this.colour = colour;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Defaultkonstruktor
	 */
	public Shape() {
		this("schwarz", 0, 0, 0);
	}
	
	/**
	 * Bewegt den Koerper um den Bewegungsvektor mit den 
	 * Bestandteilen <tt>dX</tt> in x Richtung, <tt>dY</tt>
	 * in y Richtung und <tt>dZ</tt> in z Richtung
	 * @param dX Bewegung in x Richtung
	 * @param dY Bewegung in y Richtung
	 * @param dZ Bewegung in z Richtung
	 */
	public void move(double dX, double dY, double dZ) {
		x += dX;
		y += dY;
		z += dZ;
	}
	
	/**
	 * Gibt das Volumen des Koerpers zurueck
	 * @return das Volumen
	 */
	public double getVolume() {
		return 0.0;
	}
	
	/**
	 * Gibt die Oberflaeche des Koerpers zurueck
	 * @return die Oberflaeche
	 */
	public double getArea() {
		return 0.0;
	}
	
	/**
	 * Gibt den Abstand zu einem anderen Koerper 
	 * <tt>other</tt> zurueck
	 * @param other der andere Koerper
	 * @return der Abstand zwischen dieser Koerper
	 * Instanz und dem uebergebenen Koerper <tt>other</tt>
	 */
	public double getDistanceTo(Shape other) {
		return Math.sqrt(
				(((other.x - x) * (other.x - x)) + 
				((other.y - y) * (other.y - y)) + 
				((other.z - z) * (other.z - z)))
				);
	}
	
	/**
	 * Gibt alle Eigenschaften dieses Koerpers als
	 * String Representation zurueck
	 * @return String Representation aller Eigenschaften
	 */
	public String toString() {
		return "Colour : " + colour + "\n" + 
			   "x : " + x + "\n" +
			   "y : " + y + "\n" + 
			   "z : " + z;
	}
	
}
