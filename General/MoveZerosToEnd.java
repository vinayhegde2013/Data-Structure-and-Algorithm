package com.comp.prog;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] result = movingZeros(new int[] { 1, 0, 2, 0, 0, 7, 6, 8 });
		for (int res : result) {
			System.out.println(res);
		}
	}

	private static int[] movingZeros(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while (count < arr.length)
			arr[count++] = 0;

		return arr;
	}

}
