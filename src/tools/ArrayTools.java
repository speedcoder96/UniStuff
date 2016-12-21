package tools;

import java.util.Random;

public class ArrayTools {

	public static int[] randomArray(int n, int a, int b) {
		Random random = new Random();
		if(n > 0 && a < b) {
			int[] array = new int[n];
			for(int i = 0; i < array.length; i++) {
				array[i] = a + random.nextInt(b - a);
			}
			return array;
		}
		return null;
	}
	
}
