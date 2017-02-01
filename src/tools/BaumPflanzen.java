package tools;

import de.uos.rt.exercise._11._4.BaumTools;
import de.uos.rt.exercise._11._4.VerweisBaum;

public class BaumPflanzen {

	public static void main(String[] args) {
		
		VerweisBaum b7 = new VerweisBaum(7);
		VerweisBaum b3 = new VerweisBaum(3);
		VerweisBaum b5 = new VerweisBaum(5);
		VerweisBaum b8 = new VerweisBaum(b3, 8, b7);
		
		VerweisBaum baum = new VerweisBaum(b5, 2, b8);
		
		BaumTools.printBaum(baum);
		
	}
	
}
