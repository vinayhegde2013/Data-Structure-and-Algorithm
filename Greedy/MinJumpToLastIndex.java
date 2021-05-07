package com.comp.prog;

import java.util.Scanner;

public class MinJumpToLastIndex {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(jump(a));

	}

	public static int jump(int[] nums) {
		int currentReach = 0;
		int jump = 0;
		int maxReach = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (i + nums[i] > maxReach)
				maxReach = i + nums[i];

			if (i == currentReach) {
				jump++;
				currentReach = maxReach;
			}
		}

		return jump;
	}

}
