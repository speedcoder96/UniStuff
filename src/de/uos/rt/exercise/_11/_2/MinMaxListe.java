package de.uos.rt.exercise._11._2;
import de.uos.rt.exercise._10.VerweisListe;

/**
 * Erweitert die VerweisListe um die Funktionalitaet stets Zugriff
 * auf das groesste und kleinste Element zu haben. Dabei wird davon ausgegangen,
 * dass nur Objekte eingefuegt werden, die Comparable implementieren.
 */
public class MinMaxListe extends VerweisListe {

	private Object minElem;
	private Object maxElem;
	
	public MinMaxListe() {
		minElem = null;
		maxElem = null;
	}
	
	/**
	 * 
	 */
	public void insert(Object x) {
		super.insert(x);
		compareToMinMax(x);
	}

	/**
	 *
	 */
	public void delete() {
		Object currentElement = elem();
		super.delete();
		
		if(empty()) {
			minElem = maxElem = null;
		} else if(currentElement == minElem || currentElement == maxElem) {
			if(!endpos()) {
				currentElement = elem();
			}
			reset();
			
			minElem = maxElem = elem();
			
			boolean setToDefault = false;
			boolean resetList = false;
			
			while(!setToDefault) {
				if(!resetList) {
					if(!endpos()) {
						compareToMinMax(elem());
						advance();
					} else {
						resetList = true;
						reset();
					}
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
	 * 
	 * @param current
	 */
	private void compareToMinMax(Object current) {
		Comparable currentElement = (Comparable)current;
		if(minElem == null || currentElement.compareTo(minElem) < 0) {
			minElem = current;
		} 
		if(maxElem == null || currentElement.compareTo(maxElem) > 0) {
			maxElem = current;
		}
	}
	
	
	public Object getMin() {
		return minElem;
	}
	
	public Object getMax() {
		return maxElem;
	}
	
	
}
