package com.vinay.hegde.algorithm;

public class AlternativeSorting {

	public static void main(String[] args) {

		int[] arr = new int[] { 20, 10, 4, 1, 99, 87, 75 };
		SortArray(arr, 0, arr.length - 1);
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			System.out.println(arr[start++]);
			System.out.println(arr[end--]);
		}
		if (arr.length % 2 != 0)
			System.out.print(arr[start]);
	}

	private static void SortArray(int[] arr, int left, int right) {

		if (right - left + 1 <= 1)
			return;
		int mid = left + (right - left) / 2;
		SortArray(arr, left, mid);
		SortArray(arr, mid + 1, right);
		Merge(arr, left, mid, right);

	}

	private static void Merge(int[] arr, int left, int mid, int right) {

		int k = 0;
		int low = left;
		int high = mid + 1;
		int[] result = new int[arr.length];
		while (low <= mid && high <= right) {

			if (arr[low] < arr[high]) {
				result[k++] = arr[low++];
			} else {
				result[k++] = arr[high++];
			}

		}

		while (low <= mid)
			result[k++] = arr[low++];

		while (high <= right)
			result[k++] = arr[high++];

		for (int i = left; i <= right; i++) {
			arr[i] = result[i - left];
		}
	}

}
