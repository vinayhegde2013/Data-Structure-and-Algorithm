package com.comp.prog;
//Problem : https://codingcompetitions.withgoogle.com/codejam/round/000000000043580a/00000000006d0a5c
public class Reversort {

	public static void main(String[] args) {

		int answer = 0;
		int arr[] = { 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int[] temp = new int[min - i + 1];
			for (int j = i; j <= min; j++)
				temp[j - i] = arr[j];
			// Reverse i .....min index
			for (int j = i; j <= min; j++)
				arr[j] = temp[temp.length - 1 - (j - i)];
			answer += temp.length;
		}
		System.out.println(answer);
	}
}
