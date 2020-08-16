package com.comp.prog;

import java.util.Arrays;

public class MinOperationToMakeArrayEqual {

	// Can be increment / decrement by 1 only at a time
	public static void main(String[] args) {
		System.out.println(minimumOperation(new int[] { 1, 3, 5 }));
	}

	private static int minimumOperation(int[] arr) {
		Arrays.sort(arr);
		int cost = 0;
		int mid = arr[arr.length / 2];
		for (int i = 0; i < arr.length; i++) {
			cost = Math.abs(arr[i] - mid) + cost;
		}

		if (arr.length / 2 == 0) {
			int tempcost = 0;
			int evenMid = arr[arr.length / 2 - 1];
			for (int i = 0; i < arr.length; i++) {
				tempcost = Math.abs(arr[i] - evenMid);
			}
			cost = Math.max(tempcost, cost);
		}
		return cost;
	}
}
