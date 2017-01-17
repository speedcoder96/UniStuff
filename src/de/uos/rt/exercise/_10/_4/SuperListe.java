package de.uos.rt.exercise._10._4;

import de.uos.rt.exercise._10.Keller;
import de.uos.rt.exercise._10.VerweisKeller;
import de.uos.rt.exercise._10.VerweisListe;

public class SuperListe extends VerweisListe {
	
	//Anzahl der Elemente in der SuperListe
	private int elementCount;

	public SuperListe() {
		elementCount = 0;
	}
	
	/**
	 * Dreht die Reihenfolge der SuperListe um
	 */
	public void umdrehen() {
		reset();
		Keller temp = new VerweisKeller();
		while(!empty()) {
			temp.push(elem());
			delete();
		}
		while(!temp.empty()) {
			insert(temp.top());
			temp.pop();
			advance();
		}
		reset();
	}
	
	//Ueberschrieben um die Anzahl der Elemente in der Liste zu zaehlen
	public void insert(Object x) {
		elementCount++;
		super.insert(x);
	}
	
	/**
	 * Ueberschrieben um die Anzahl der Elemente in der Liste zu zaehlen
	 */
	public void delete() {
		elementCount--;
		super.delete();
	}
	
	/**
	 * Entfernt alle doppelten Elemente aus dieser SuperListe
	 */
	public void unique() {
		reset();
		for(int i = 0; i < elementCount; i++) {
			for(int j = i + 1; j < elementCount; j++) {
				Object current = elem(i);
				Object other = elem(j);
				if(current.equals(other)) {
					delete();
				}
			}
		}
		reset();
	}
	
	/**
	 * Gibt das Objekt an der n-ten Stelle der SuperListe zurueck
	 * @param n n-tes Element (erstes Element beginnend bei 0)
	 * @return gibt das n-te Element der SuperListe zurueck
	 */
	public Object elem(int n)  {
		if(n < 0) {
			throw new RuntimeException("n muss >= 0 sein");
		}
		reset();
		for(int i = 0; i < n; i++) {
			if(endpos()) {
				throw new RuntimeException("Element existiert nicht");
			}
			advance();
		}
		return elem();
	}
	
}
