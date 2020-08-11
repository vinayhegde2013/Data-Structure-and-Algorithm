package com.comp.prog;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		System.out.println(longestSubsequence(new int[] { 2, 8, 1, 8, 2, 101, 67 }));
	}

	public static int longestSubsequence(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int[] longestSeq = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
			longestSeq[i] = 1;

		int max = 1;
		
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i];
			for (int j = 0; j < i; j++) {
				if (value > nums[j] && longestSeq[j] + 1 > longestSeq[i]) {
					longestSeq[i] = longestSeq[j] + 1;
					max = Math.max(max, longestSeq[i]);
				}
			}
		}
		return max;
	}
}
