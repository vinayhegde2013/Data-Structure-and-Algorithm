package com.comp.prog;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] result = movingZeros(new int[] { 1, 0, 2, 0, 0, 7, 6, 8 });
		for (int res : result) {
			System.out.println(res);
		}
		
// 		int[] arr = new int[] { 0, 5, 0, 1, 2, 0, 2, 1, 0 };
// 		moveZerosToEnd(arr);
// 		for (int i = 0; i < arr.length; i++)
// 			System.out.println(arr[i]);
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

// private static void moveZerosToEnd(int[] arr) {
// 		int left = 0;
// 		int right = arr.length - 1;

// 		while (left <= right) {
// 			if (arr[left] == 0) {
// 				swap(left, right, arr);
// 				right--;
// 			} else {
// 				left++;
// 			}
// 		}
// }

// private static void swap(int i, int j, int[] arr) {

// 		int temp = arr[i];
// 		arr[i] = arr[j];
// 		arr[j] = temp;
// }

