package de.uos.rt.exercise._12._4;

public class Firma implements Comparable {

	//Name der Firma
	private String name;
	//Umsatzsteueridentifikationsnummer
	private long vatIdentificationNum;
	//Jahresumsatz
	private long annualRevenue;
	
	/**
	 * Firma Konstruktor
	 * @param name Name der Firma
	 * @param vatIdentificationNum Umsatzsteueridentifikationsnummer
	 * @param annualRevenue Jahresumsatz
	 */
	public Firma(String name, long vatIdentificationNum, long annualRevenue) {
		this.name = name;
		setVatIdentificationNum(vatIdentificationNum);
		this.annualRevenue = annualRevenue;
	}
	
	/**
	 * Setzt den Namen der Firma
	 * @param name der Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gibt den Namen der Firma zurueck
	 * @return den Namen
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzt die Umsatzsteueridentifikationsnummer. Diese darf nur 
	 * im positiven Bereich sein
	 * @param vatIdentificationNum die Umsatzsteueridentifikationsnummer
	 * @throw RuntimeException wenn die Umsatzsteueridentifikationsnummer
	 * negativ ist
	 */
	public void setVatIdentificationNum(long vatIdentificationNum) {
		if(vatIdentificationNum < 0) {
			throw new RuntimeException("UstId muss positiv sein");
		}
		this.vatIdentificationNum = vatIdentificationNum;
	}
	
	/**
	 * Gibt die Umsatzsteueridentifikationsnummer zurueck
	 * @return die Umsatzsteueridentifikationsnummer
	 */
	public long getVatIdentificationNum() {
		return vatIdentificationNum;
	}
	
	/**
	 * Setzt den Jahresumsatz der Firma
	 * @param annualRevenue der Jahresumsatz
	 */
	public void setAnnualRevenue(long annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	
	/**
	 * Gibt den Jahresumsatz der Firma zurueck
	 * @return den Jahresumsatz
	 */
	public long getAnnualRevenue() {
		return annualRevenue;
	}
	
	/**
	 * Vergleicht diese Objekt Instanz mit einer anderen
	 * auf Groesser-Kleiner Beziehnung
	 * @param other die andere Objekt Instanz
	 * @return < 0 wenn kleiner, > 0 wenn groesser, = 0 wenn gleich
	 */
	public int compareTo(Object other) {
		if(!(other instanceof Firma)) {
			throw new RuntimeException("other muss eine Instanz "
					+ "der Klasse Firma sein");
		}
		Firma o = (Firma)other;
		long difference = vatIdentificationNum - o.getVatIdentificationNum();
		if(difference < 0) {
			return -1;
		} else if(difference == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * Gibt den Hashcode der Firma zurueck. Hier die
	 * Umsatzsteueridentifikationsnummer
	 * @return den Hashcode
	 */
	public int hashCode() {
		return (int)vatIdentificationNum;
	}
	
	/**
	 * Vergleicht diese Instanz mit einer anderen Instanz
	 * auf Gleichheit
	 * @param other die andere Instanz
	 * @return true wenn gleich, andernfalls false
	 */
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		} else if(compareTo(other) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gibt eine String-Representation des Objektes zurueck
	 * @return eine String-Representation
	 */
	public String toString() {
		return "\nName:\t\t" + name + 
			   "\nUStId:\t\t" + vatIdentificationNum + 
			   "\nJahresumsatz:\t" + annualRevenue + "\n"; 
	}
	
	

}
