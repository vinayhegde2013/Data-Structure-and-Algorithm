package com.vinay.hegde.algorithm;

public class ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		// Time Complexity : O(NumberOfElement*Capacity) i.e O(n*capacity)
		int n = 5;
		int capacity = 30;
		int weight[] = { 10, 20, 1, 9, 90 };
		int profit[] = { 2, 3, 99, 21, 8 };
		System.out.println(calculateKnapSack(n, capacity, weight, profit));

	}

	private static int calculateKnapSack(int n, int capacity, int[] weight, int[] profit) {

		int dp[][] = new int[n + 1][capacity + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (weight[i - 1] <= capacity)
					// first case : include item ( currentProfit + remaining profit )
					// Second case : exclude item ( previous profit)
					dp[i][capacity] = Math.max(profit[i - 1] + dp[i - 1][capacity - weight[i - 1]],
							dp[i - 1][capacity]);
				else
					dp[i][capacity] = dp[i - 1][capacity];
			}
		}
		return dp[n][capacity];
	}
}
