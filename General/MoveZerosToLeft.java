package com.comp.prog;

import java.util.Arrays;

public class MoveZerosToLeft {

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 8, 0, 1, 6, 20, 4, 0 };
		moveZerosToLeft(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void moveZerosToLeft(int[] arr) {

		if (arr.length < 1)
			return;
		int left = arr.length - 1;
		int right = arr.length - 1;

		while (right >= 0) {
			if (arr[right] != 0) {
				arr[left] = arr[right];
				left--;
			}
			right--;
		}

		while (left >= 0) {
			arr[left] = 0;
			left--;
		}

	}

}
