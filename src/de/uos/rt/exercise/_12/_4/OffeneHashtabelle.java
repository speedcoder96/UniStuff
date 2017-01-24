package de.uos.rt.exercise._12._4;

public class OffeneHashtabelle implements Menge {
	
	private Liste[] lists;
	private int n;
	
	public OffeneHashtabelle(int n) {
		createLists(n);
	}
	
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

	public boolean empty() {
		for(int i = 0; i < lists.length; i++) {
			if(!lists[i].empty()) {
				return false;
			}
		}
		return true;
	}	

	public boolean insert(Comparable x) {
		int hashCode = hashCode(x);
		
		if(lookup(x) != null) {
			return false;
		} else {
			lists[hashCode].insert(x);
			return true;
		}
		
	}
	
	public boolean delete(Comparable x) {
		int hashCode = hashCode(x);
			
		if(lookup(x) != null) {
			if(containsOnIterate(x, lists[hashCode])) {
				lists[hashCode].delete();
				return true;
			}
		}
		
		return false;
	}
	
	public Comparable lookup(Comparable x) {
		int hashCode = hashCode(x);
				
		if(containsOnIterate(x, lists[hashCode])) {
			return (Comparable)lists[hashCode].elem();
		}

		return null;
	}
	
	private boolean containsOnIterate(Comparable x, Liste list) {
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
	
	private int hashCode(Comparable x) {
		if(x == null) {
			throw new RuntimeException("x ist null");
		}
		int hashCode = x.hashCode();
		return ((hashCode < 0) ? -hashCode : hashCode) % n;
	}
	
}
