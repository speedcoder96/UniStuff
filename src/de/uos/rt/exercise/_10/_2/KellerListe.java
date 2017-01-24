package de.uos.rt.exercise._10._2;

import de.uos.rt.exercise._10.Liste;
import de.uos.rt.exercise._10.VerweisKeller;

public class KellerListe implements Liste {

	//Keller der die vordere Haelfte beinhaltet
	private VerweisKeller front;
	//Keller der die hintere Haelfte beinhaltet
	private VerweisKeller back;
	
	
	public KellerListe() {
		front = new VerweisKeller();
		back = new VerweisKeller();
	}
	
	/**
	 * Ueberprueft ob die Liste leer ist
	 * @return true wenn Liste leer, sonst false
	 */
	public boolean empty() {
		//ist leer wenn beide Keller leer sind
		return front.empty() && back.empty();
	}

	/**
	 * Ueberprueft ob sich die Liste an der letzten Stelle
	 * befindet
	 * @return true wenn Liste an letzter Stelle, sonst false
	 */
	public boolean endpos() {
		return back.empty();
	}

	/**
	 * Setzt die Liste auf die Anfangsposition zurueck
	 */
	public void reset() {
		while(!front.empty()) {
			back.push(front.top());
			front.pop();
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
		front.push(back.top());
		back.pop();
	}

	/**
	 * Gibt das aktuelle Element der Liste zurueck
	 * @return das aktuelle Element
	 */
	public Object elem() {
		if(empty()) {
			throw new RuntimeException("KellerListe ist leer");
		}
		return back.top();
	}

	/**
	 * Fuegt ein neues Element in die Liste ein
	 * @param x das neue Element
	 */
	public void insert(Object x) {
		if(x == null) {
			throw new RuntimeException("Das uebergebene Objekt ist null");
		}
		front.push(x);
	}

	/**
	 * Loescht das aktuelle Element der Liste
	 */
	public void delete() {
		if(endpos()) {
			throw new RuntimeException("Endposition erreicht");
		}
		back.pop();
	}

}
