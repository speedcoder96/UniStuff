package de.uos.rt.exercise._10;

public class VerweisKeller implements Keller {

	private Eintrag top;
	
	public VerweisKeller() {
		top = null;
	}

	public boolean empty() {
		return top == null;
	}

	public void push(Object data) {
		Eintrag temp = new Eintrag();
		temp.inhalt = data;
		temp.next = top;
		top = temp;
	}

	public Object top() {
		if(empty()) {
			throw new RuntimeException("Liste ist leer");
		}
		return top.inhalt;
 	}

	public void pop() {
		if(empty()) {
			throw new RuntimeException("Liste ist leer");
		}
		top = top.next;
	}
	
}
