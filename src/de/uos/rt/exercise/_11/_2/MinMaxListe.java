package de.uos.rt.exercise._11._2;
import de.uos.rt.exercise._10.VerweisListe;

/**
 * Erweitert die VerweisListe um die Funktionalitaet stets Zugriff
 * auf das groesste und kleinste Element zu haben. Dabei wird davon ausgegangen,
 * dass nur Objekte eingefuegt werden, die Comparable implementieren.
 */
public class MinMaxListe extends VerweisListe {

	//das Minimum-Element
	private Object minElem;
	//das Maximum-Element
	private Object maxElem;
	
	/**
	 * MinMaxListe Konstruktor
	 */
	public MinMaxListe() {
		minElem = null;
		maxElem = null;
	}
	
	/**
	 * Fuegt ein neues Element der Liste hinzu
	 */
	public void insert(Object x) {
		super.insert(x);
		compareToMinMax(x);
	}

	/**
	 * Loescht das aktuelle Element aus der Liste
	 */
	public void delete() {
		//aktuelles Element zwischenspeichern
		Object currentElement = elem();
		super.delete();
		
		if(empty()) {
			//Speicher aufraeumen
			minElem = maxElem = null;
			//wenn das entfernte Element das Minimum oder Maximum war
		} else if(currentElement == minElem || currentElement == maxElem) {
			//aktuelle Position der Liste zwischenspeichern
			if(!endpos()) {
				currentElement = elem();
			}
			reset();
			
			//Annahme das das Maximum das erste Element der Liste ist
			minElem = maxElem = elem();
			
			boolean setToDefault = false;
			boolean resetList = false;
			
			while(!setToDefault) {
				//neues Minimum und Maximum finden
				if(!resetList) {
					if(!endpos()) {
						compareToMinMax(elem());
						advance();
					} else {
						//Liste zuruecksetzen
						resetList = true;
						reset();
					}
					//Liste wieder zur urspruenglichen Position zuruecksetzen
				} else {
					if(!endpos() && currentElement != elem()) {
						advance();
					} else {
						setToDefault = true;
					}
				}
			}
		}
	}
	
	/**
	 * Vergleicht das <tt> current </tt> mit dem
	 * Minimum und dem Maximum aus dieser Klasse und
	 * setzt diese neu.
	 * @param current das Element das mit Minimum und Maximum
	 * vergleicht werden soll
	 */
	private void compareToMinMax(Object current) {
		Comparable currentElement = (Comparable)current;
		//vergleicht das Element mit dem Minimum
		if(minElem == null || currentElement.compareTo(minElem) < 0) {
			minElem = current;
		} 
		//vergleicht das Element mit dem Maximum
		if(maxElem == null || currentElement.compareTo(maxElem) > 0) {
			maxElem = current;
		}
	}
	
	/**
	 * Gibt das aktuelle Minimum zurueck
	 * @return das aktuelle Minimum
	 */
	public Object getMin() {
		return minElem;
	}
	
	/**
	 * Gibt das aktuelle Maximum zurueck
	 * @return das aktuelle Maximum
	 */
	public Object getMax() {
		return maxElem;
	}
	
	
}
