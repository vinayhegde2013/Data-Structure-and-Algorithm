package com.vinay.hegde.programming;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int noOfStalls = s.nextInt();
		int noOfCows = s.nextInt();

		int[] stall = new int[noOfStalls];
		for (int i = 0; i < noOfStalls; i++) {
			stall[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(stall);
		System.out.println(Solve(noOfCows, stall));
	}

	private static int Solve(int noOfCows, int[] stall) {
		int left = 0;
		int right = stall[stall.length - 1] - stall[0];
		while (left <= right) {
			int mid = left + right / 2;
			if (isValid(mid, noOfCows, stall))
				left = mid + 1;
			else
				right = mid - 1;

		}
		return right;

	}

	private static boolean isValid(int mid, int noOfCows, int[] stall) {
		int noOfCowPlaced = 1;
		int end = stall[0];
		for (int i = 1; i < stall.length; i++) {
			if (stall[i] - end < mid)
				continue;
			if (++noOfCowPlaced == noOfCows)
				return true;
			end = stall[i];
		}
		return false;
	}

}
