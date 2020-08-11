package com.comp.prog;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		System.out.println(longestSubsequence(new int[] { 2, 8, 1, 8, 2, 101, 67 }));
	}

	public static int longestSubsequence(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;

		int maximum = 0;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = max + 1;
			maximum = Math.max(dp[i], maximum);
		}

		return maximum;
	}
}
