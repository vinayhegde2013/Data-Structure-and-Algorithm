package com.vinay.hegde.algorithm;

public class ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		// Time Complexity : O(NumberOfElement*Capacity) i.e O(n*capacity)
		int n = 5;
		int capacity = 30;
		int weight[] = { 10, 20, 1, 9, 90 };
		int profit[] = { 2, 3, 99, 21, 8 };
		System.out.println(calculateKnapSack(n, capacity, profit, weight));

	}

	 private static int calculateKnapSack(int n,int c, int[] value, int[] weight){
        int dp[][]=new int[n+1][c+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=c;j++){
                if(i==0 || j==0)
                    dp[i][j]=0; 
                else if(weight[i-1]<=j)
					// first case : include item ( currentProfit + remaining profit )
					// Second case : exclude item ( previous profit)
                    dp[i][j]=Math.max( value[i-1] +dp[i-1][j-weight[i-1]], dp[i-1][j] );
                else
                    dp[i][j]=dp[i-1][j];           
            }
        }
        return dp[n][c];
    }
}
