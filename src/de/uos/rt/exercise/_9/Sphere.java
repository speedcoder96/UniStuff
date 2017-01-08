package de.uos.rt.exercise._9;

public class Sphere extends Shape {
	
	/**
	 * Radius der Kugel
	 */
	private double radius;
	
	/**
	 * Konstruktor der Kugel
	 * @param colour Farbe der Kugel
	 * @param x die x Koordinate
	 * @param y die y Koordinate
	 * @param z die z Koordinate
	 * @param radius der Radius der Kugel
	 */
	public Sphere(String colour, double x, double y, double z, double radius) {
		super(colour, x, y, z);
		setRadius(radius);
	}

	/**
	 * Setzt den Radius der Kugel
	 * @param radius der neue Radius
	 */
	public void setRadius(double radius) {
		if(radius <= 0) {
			throw new RuntimeException("Radius darf nicht null oder negativ sein");
		}
		this.radius = radius;
	}
	
	/**
	 * Gibt den Radius der Kugel zurueck
	 * @return den Radius der Kugel
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Gibt das Volumen der Kugel zurueck
	 * @return das Volumen der Kugel
	 */
	public double getVolume() {
		return (4 / 3) * Math.PI * radius * radius * radius;
	}

	/**
	 * Gibt die Oberflaeche der Kugel zurueck
	 * @return die Oberflaeche der Kugel
	 */
	public double getArea() {
		return 4 * Math.PI * radius * radius;
	}
	
	/**
	 * Gibt den Abstand zwischen dieser Kugel Instanz
	 * und einem anderen Koerper <tt>other</tt> zurueck
	 * @return der Abstand zwischen dieser Kugel und dem 
	 * anderen Koeper <tt>other</tt>
	 */
	public double getDistanceTo(Shape other) {
		if(other instanceof Sphere) {
			Sphere sphere = (Sphere)other;
			double diffX = (sphere.x - x);
			double diffY = (sphere.y - y);
			double diffZ = (sphere.z - z);
			return Math.sqrt(((diffX * diffX) + (diffY * diffY) + (diffZ * diffZ) - 
					radius - sphere.getRadius()));
		}
		return super.getDistanceTo(other);
	}

	/**
	 * Gibt alle Eigenschaften der Kugeln in einer
	 * String Representation zurueck
	 * @return alle Eigenschaften als String Representation
	 */
	public String toString() {
		return super.toString() + "\nradius : " + radius;
	}

}
