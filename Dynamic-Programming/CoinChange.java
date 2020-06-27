package com.vinay.hegde.algorithm;

import java.util.Scanner;
/**
 * -------------------------Problem Statement------------------------------
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * */
public class CoinChange {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int coins[] = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = s.nextInt();
		}
		int amount = s.nextInt();
		s.close();
		System.out.println(change(amount, coins));

	}

	public static int change(int amount, int[] coins) {
		int dp[] = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++)
				dp[i] += dp[i - coin];
		}
		return dp[amount];
	}

}
