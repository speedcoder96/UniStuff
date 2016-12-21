package de.uos.rt.exercise._6;

public class BinarySearch {
	
	public static int steps;
	
	private static int rek(int[] list, int searchFor, int left, int right) {
		steps++;
		int middle = (left + right) / 2;
		if(left <= right && list[middle] != searchFor) {
			if(list[middle] < searchFor)
				return rek(list, searchFor, left + 1, right);
			else
				return rek(list, searchFor, left, right - 1);
		} else if(left > right) {
			return -1;
		}
		return middle;
	}
	
	public static int rek(int[] list, int searchFor) {
		return rek(list, searchFor, 0, list.length - 1);
	}


}
