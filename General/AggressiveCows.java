package com.vinay.hegde.programming;

import java.util.Arrays;
import java.util.Scanner;

/**
* Problem Statement : https://www.spoj.com/problems/AGGRCOW/
* Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
* His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
* --------Input----------
* t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
* --------Output----------
*For each test case output one integer: the largest minimum distance.
*/
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
