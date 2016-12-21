package de.uos.rt.exercise._6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LaufzeitenTest {

	/**
	 * Randnotizen aus Informatik Uebung vom 01.12.2016:
	 * 
	 * p(n) berechnet n^2 in n Schritten O(n)
	 * q(m) berechnet log m in log m Schritten O(log m)
	 * 
	 * p(q(k)) Aufwand: log k + log k = 2 * log k -> O(log k)
	 * 
	 * p(r) + q(r) Aufwand: r + log r <= r + r = 2r -> O(r)  
	 * da r die domenierende Laufzeitklasse gegebenüber log r ist,
	 * ist die Laufzeitklasse O(r)
	 * 
	 * Laufzeitklasse der rekursiven Methode:
	 * 
	 * public int rek(int n) {
	 * 	if(n == 1) return 1;
	 * 	return rek(n - 1) + rek(n - 1);
	 * }
	 * 
	 * F(n) = { 1 : n = 1, F(n-1) + F(n-1) sonst
	 * 
	 * Backtracking : 
	 * 
	 * FFFF
	 * FFFF
	 * FFFF
	 * FFFF
	 * 
	 * 1FFF
	 * FF2F
	 * FFFF
	 * FFFF
	 * 
	 * 1FFF
	 * FF2F
	 * FFFF
	 * F3FF
	 * 
	 * 1FFF
	 * FF2F
	 * FFFF
	 * FFFF
	 * 
	 * 1FFF
	 * FFF2
	 * FFFF
	 * FFFF
	 * 
	 * 1FFF
	 * FFF2
	 * F3FF
	 * FFFF
	 * 
	 * 1FFF
	 * FFF2
	 * FFFF
	 * FF3F
	 * 
	 * 1FFF
	 * FFFF
	 * FFFF
	 * FFFF
	 * 
	 * 1FFF
	 * FFFF
	 * F2FF
	 * FFFF
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
	
		File file = new File(".\\src\\uebungen6\\Laufzeiten.java");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write("//Hallo Welt");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}