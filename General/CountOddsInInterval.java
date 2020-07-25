package com.comp.prog;

//Constraints: 0 <= low <= high <= 10^9

public class CountOddNumbers {

	public static void main(String[] args) {
		System.out.println(countOdd(3, 7));
	}

	private static int countOdd(int low, int high) {
		int count = (high - low) / 2;
		if (high % 2 != 0 || low % 2 != 0)
			count++;
		return count;
	}
}
