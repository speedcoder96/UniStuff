package de.uos.rt.exercise._12._4;

public class OffeneHashtabelle implements Menge {
	
	//die Hashtabelle
	private Liste[] lists;
	//Groesse der Hashtabelle
	private int n;
	
	/**
	 * OffeneHashtabelle Konstruktor
	 * @param n die Groesse der Hashtabelle
	 */
	public OffeneHashtabelle(int n) {
		createLists(n);
	}
	
	public OffeneHashtabelle() {
		createLists(7);
	}
	
	/**
	 * Legt eine Hashliste an mit <tt> n </tt> Plaetzen
	 * @param n Anzahl der reservierten Plaetze
	 */
	private void createLists(int n) {
		if(n <= 0) {
			throw new RuntimeException("n muss positiv und groesser "
					+ "als 0 sein");
		}
		this.n = n;
		lists = new Liste[n];
		for(int i = 0; i < lists.length; i++) {
			lists[i] = new VerweisListe();
		}
	}

	/**
	 * Ueberprueft ob die Hashtabelle leer ist
	 * @return true wenn leer, false sonst
	 */
	public boolean empty() {
		for(int i = 0; i < lists.length; i++) {
			if(!lists[i].empty()) {
				return false;
			}
		}
		return true;
	}	

	/**
	 * Fuegt ein Element der Hashtabelle zu
	 * @param x das einzufuegende Element
	 * @return true wenn das Element korrekt eingefuegt werden
	 * konnte, false wenn nicht
	 */
	public boolean insert(Comparable x) {
		int hashCode = hashCode(x);
		if(lookup(x) != null) {
			return false;
		} else {
			lists[hashCode].insert(x);
			return true;
		}
	}
	
	/**
	 * Loescht das Element <tt> x </tt> aus der 
	 * Hashtabelle
	 * @param x das zu loeschende Element
	 * @return true wenn das Element korrekt geloescht wurde,
	 * false wenn nicht 
	 */
	public boolean delete(Comparable x) {
		int hashCode = hashCode(x);	
		if(lookup(x) != null) {
			if(contains(x, lists[hashCode])) {
				lists[hashCode].delete();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sucht das Element <tt> x </tt> in der 
	 * Hashtabelle
	 * @param x das zu suchende Element
	 * @return gibt das gefundene Element zurueck, andernfalls
	 * ist das Ergebnis null
	 */
	public Comparable lookup(Comparable x) {
		int hashCode = hashCode(x);
		if(contains(x, lists[hashCode])) {
			return (Comparable)lists[hashCode].elem();
		}
		return null;
	}
	
	/**
	 * Ueberprueft ob ein Element <tt> x </tt> in einer Liste
	 * <tt> list </tt> enthalten ist. Behaelt die aktuelle
	 * Position in der Liste an der das Element gefunden wurde.
	 * @param x das zu ueberpruefende Element
	 * @param list die zu ueberpruefende Liste
	 * @return true wenn das Element <tt> x </tt> in 
	 * der Liste <tt> list </tt> enthalten ist, andernfalls
	 * false
	 */
	private boolean contains(Comparable x, Liste list) {
		list.reset();
		while(!list.endpos()) {
			Object current = list.elem();
			if(current.equals(x)) {
				return true;
			}
			list.advance();
		}
		return false;
	}
	
	/**
	 * Gibt den absoluten Hashwert des Element <tt> x </tt> 
	 * im Bereich 0 bis n zurueck
	 * @param x das zu hashende Element
	 * @return den absoluten Hashwert im Intervall 0 bis n
	 * @throws RuntimeException wenn <tt> x </tt> null ist 
	 */
	private int hashCode(Comparable x) {
		if(x == null) {
			throw new RuntimeException("x ist null");
		}
		int hashCode = x.hashCode();
		return ((hashCode < 0) ? -hashCode : hashCode) % n;
	}
	
}
