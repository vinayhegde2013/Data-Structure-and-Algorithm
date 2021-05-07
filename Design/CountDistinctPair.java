package com.comp.prog;

import java.util.Arrays;

//Find the count of distinct pair of a given sum
public class CountDistinctPair {

	public static void main(String args[]) {

		int target = 13;
		findCountOfPairs(new int[] { 5, 6, 5, 7, 7, 8 }, target);
	}

	private static void findCountOfPairs(int[] array, int target) {

		Arrays.sort(array);

		int count = 0;
		int left = 0;
		int right = array.length - 1;

		while (left < right) {

			if (array[left] + array[right] == target) {
				while (left < right && array[left] == array[left + 1])
					left++;
				while (left < right && array[right] == array[right - 1])
					right--;
				left++;
				right--;
				count++;
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(count);

	}
}
