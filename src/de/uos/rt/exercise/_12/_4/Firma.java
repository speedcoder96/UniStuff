package de.uos.rt.exercise._12._4;

public class Firma implements Comparable {

	private String name;
	private long vatIdentificationNum;
	private long annualRevenue;
	
	public Firma(String name, long vatIdentificationNum, long annualRevenue) {
		this.name = name;
		setVatIdentificationNum(vatIdentificationNum);
		this.annualRevenue = annualRevenue;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVatIdentificationNum(long vatIdentificationNum) {
		if(vatIdentificationNum < 0) {
			throw new RuntimeException("UstId muss positiv sein");
		}
		this.vatIdentificationNum = vatIdentificationNum;
	}
	
	public long getVatIdentificationNum() {
		return vatIdentificationNum;
	}
	
	public void setAnnualRevenue(long annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	
	public long getAnnualRevenue() {
		return annualRevenue;
	}
	
	public int compareTo(Object other) {
		if(!(other instanceof Firma)) {
			throw new RuntimeException("other muss eine Instanz "
					+ "der Klasse Firma sein");
		}
		Firma o = (Firma)other;
		return (int)(vatIdentificationNum - o.getVatIdentificationNum());
	}
	
	public int hashCode() {
		return (int)vatIdentificationNum;
	}
	
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		} else if(compareTo(other) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Name: \t " + name + 
			   "UStId: \t " + vatIdentificationNum + 
			   "Jahresumsatz : \t " + annualRevenue; 
	}
	
	

}
