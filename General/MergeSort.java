package com.comp.prog;

public class MergeSort {

	public static void main(String[] args) {
		int nums[] = new int[] { 3, 4, 1, 90, 24 };
		int N = nums.length;
		mergeSort(nums, 0, N - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	static void mergeSort(int[] nums, int start, int end) {
		if (end - start + 1 <= 1)
			return;
		int mid = start + (end - start) / 2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	static void merge(int[] nums, int start, int mid, int end) {
		int low = start;
		int high = mid + 1;
		int[] buffer = new int[end - start + 1];
		int t = 0;

		while (low <= mid && high <= end) {
			if (nums[low] < nums[high]) {
				buffer[t++] = nums[low++];
			} else {
				buffer[t++] = nums[high++];
			}
		}

		while (low <= mid)
			buffer[t++] = nums[low++];
		while (high <= end)
			buffer[t++] = nums[high++];
		for (int i = start; i <= end; i++) {
			nums[i] = buffer[i - start];
		}
	}

}
