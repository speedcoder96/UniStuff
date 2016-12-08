package de.uos.rt.exercise._6;

public class BinarySearch {
	
	private static boolean rek(int[] list, int searchFor, int left, int right) {
		int middle = (left + right) / 2;
		if(left <= right && list[middle] != searchFor) {
			if(list[middle] < searchFor)
				return rek(list, searchFor, left + 1, right);
			else
				return rek(list, searchFor, left, right - 1);
		} else if(left > right) {
			return false;
		}
		return true;
	}
	
	public static boolean rek(int[] list, int searchFor) {
		return rek(list, searchFor, 0, list.length - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(rek(new int[]{2,3,23,25,27,39,44,48}, 44)); 
		
	}

}
