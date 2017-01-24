package de.uos.rt.exercise._12._3;

public class NameHashing {

	public static final char[] VOWELS = {'a','e','i','o','u'};
	
	public static int hash(String name) {
		int vowelCount = 0;
		boolean vowelFound = false;
		name = name.toLowerCase();
		for(int i = 0; i < name.length(); i++) {
			vowelFound = false;
			for(int j = 0; j < VOWELS.length && !vowelFound; j++) {
				if(name.charAt(i) == VOWELS[j]) {
					vowelCount++;
					vowelFound = true;
				}
			}
		}
		return (vowelCount + name.length()) % 8;
	}
	
	public static void main(String[] args) {
		
		System.out.println(hash("Markus"));
		System.out.println(hash("Miriam"));
		System.out.println(hash("Johan"));
		System.out.println(hash("Till"));
		System.out.println(hash("Lena"));
		System.out.println(hash("Niels"));
		System.out.println(hash("Kevin"));
		System.out.println(hash("Valentin"));
		System.out.println(hash("Christian"));
		
	}
	
}
