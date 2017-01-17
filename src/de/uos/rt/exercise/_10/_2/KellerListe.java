package de.uos.rt.exercise._10._2;

import de.uos.rt.exercise._10.Liste;
import de.uos.rt.exercise._10.VerweisKeller;

public class KellerListe implements Liste {

	//Keller der die aktuellen Elemente beinhaltet
	private VerweisKeller current;
	//Keller der alle weiteren Elemente beinhaltet
	private VerweisKeller others;
	
	
	public KellerListe() {
		current = new VerweisKeller();
		others = new VerweisKeller();
	}
	
	/**
	 * Ueberprueft ob die Liste leer ist
	 * @return true wenn Liste leer, sonst false
	 */
	public boolean empty() {
		//ist leer wenn beide Keller leer sind
		return current.empty() && others.empty();
	}

	/**
	 * Ueberprueft ob sich die Liste an der letzten Stelle
	 * befindet
	 * @return true wenn Liste an letzter Stelle, sonst false
	 */
	public boolean endpos() {
		return others.empty();
	}

	/**
	 * Setzt die Liste auf die Anfangsposition zurueck
	 */
	public void reset() {
		while(!current.empty()) {
			others.push(current.top());
			current.pop();
		}
		if(!empty()) {
			current.push(others.top());
			others.pop();
		}
	}

	/**
	 * Setzt das aktuelle Element auf das naechste Element in der
	 * Liste
	 */
	public void advance() {
		if(endpos()) {
			throw new RuntimeException("Endposition erreicht");
		}
		current.push(others.top());
		others.pop();
	}

	/**
	 * Gibt das aktuelle Element der Liste zurueck
	 * @return das aktuelle Element
	 */
	public Object elem() {
		if(empty()) {
			throw new RuntimeException("KellerListe ist leer");
		}
		return current.top();
	}

	/**
	 * Fuegt ein neues Element in die Liste ein
	 * @param x das neue Element
	 */
	public void insert(Object x) {
		if(!current.empty()) {
			others.push(current.top());
			current.pop();
		}
		current.push(x);
	}

	/**
	 * Loescht das aktuelle Element der Liste
	 */
	public void delete() {
		if(endpos()) {
			throw new RuntimeException("Endposition erreicht");
		}
		if(!current.empty()) {
			current.pop();
		}
		current.push(others.top());
		others.pop();
	}

}
