package de.uos.rt.exercise._10._3;

import de.uos.rt.exercise._10.Eintrag;
import de.uos.rt.exercise._10.Schlange;

public class VerweisSchlange implements Schlange {
	
	private Eintrag head;
	private Eintrag tail;
	
	public VerweisSchlange() {
		head = null;
		tail = null;
	}

	/**
	 * Ueberprueft ob die Schlange leer ist und gibt 
	 * das Ergebnis zurueck
	 * @return true wenn Schlange leer, sonst false
	 */
	public boolean empty() {
		return head == null;
	}

	/**
	 * Fuegt ein neues Element ans Ende der Schlange
	 * ein
	 * @param x das einzufuegende Element
	 */
	public void enq(Object x) {
		Eintrag temp = new Eintrag();
		temp.inhalt = x;
		
		if(empty()) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = tail.next;
		}
		
		tail.next = null;
	}
	
	/**
	 * Gibt den Inhalt des vorderen Elements der Schlange zurueck
	 * @return den Inhalt des vorderen Elements
	 */
	public Object front() {
		if(empty()) {
			throw new RuntimeException("Schlange leer");
		}
		return head.inhalt;
	}

	/**
	 * 
	 */
	public void deq() {
		if(empty()) {
			throw new RuntimeException("Schlange leer");
		}
		head = head.next;
		if(head == null) {
			tail = head;
		}
		
	}

}
