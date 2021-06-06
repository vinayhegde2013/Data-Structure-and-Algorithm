package com.comp.prog;

public class RatInMaze {

	public static void main(String[] args) {

		int[][] arr = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		SolveMazeUtil(arr);
	}

	private static void SolveMazeUtil(int[][] arr) {
		int[][] sol = new int[arr.length][arr.length];

		if (SolveMaze(arr, 0, 0, sol) == false)
			System.out.println("No Solution");
		else
			printSol(sol);
	}

	private static boolean SolveMaze(int[][] arr, int i, int j, int[][] sol) {

		if (i == arr.length - 1 && j == arr.length - 1 && arr[i][j] == 1) {
			sol[i][j] = 1;
			return true;
		}
		if (isSafe(arr, i, j)) {
			if (sol[i][j] == 1)
				return false;
			sol[i][j] = 1;
			if (SolveMaze(arr, i + 1, j, sol))
				return true;
			if (SolveMaze(arr, i, j + 1, sol))
				return true;
			if (SolveMaze(arr, i - 1, j, sol))
				return true;
			if (SolveMaze(arr, i, j - 1, sol))
				return true;

			sol[i][j] = 0;
			return false;

		}
		return false;
	}

	private static boolean isSafe(int[][] arr, int i, int j) {

		return (i >= 0) && (i < arr.length) && (j >= 0) && (j < arr.length) && (arr[i][j] == 1);
	}

	private static void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

}
