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
	
//     void merge(int nums[], int l, int m, int r)
//     {
//         int n1 = m - l + 1;
//         int n2 = r - m;

//         int L[] = new int[n1];
//         int R[] = new int[n2];
 
//         for (int i = 0; i < n1; ++i)
//             L[i] = nums[l + i];
//         for (int j = 0; j < n2; ++j)
//             R[j] = nums[m + 1 + j];
 
//         //Index of first and second arrays
//         int i = 0, j = 0;
 
//         // Index of merged array
//         int k = l;
//         while (i < n1 && j < n2) {
//             if (L[i] <= R[j]) {
//                 nums[k] = L[i];
//                 i++;
//             }
//             else {
//                 nums[k] = R[j];
//                 j++;
//             }
//             k++;
//         }
 
//         while (i < n1) {
//             nums[k] = L[i];
//             i++;
//             k++;
//         }
 

//         while (j < n2) {
//             nums[k] = R[j];
//             j++;
//             k++;
//         }
//     }

}
