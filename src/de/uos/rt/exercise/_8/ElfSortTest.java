package de.uos.rt.exercise._8;

import AlgoTools.IO;

public class ElfSortTest {

	public static void main(String[] args) {
		int[] presents;
		do {
			presents = IO.readInts("Geben Sie Paketnummer ein : ");
		} while(presents.length == 0);
		presents = ElfSort.sort(presents);
	}
}
