package com.comp.prog;

import java.util.Scanner;

public class PermutationOfString {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		String st = scanner.nextLine();
		scanner.close();
		findPermutation(st, 0, st.length() - 1);

	}

	private static void findPermutation(String st, int left, int right) {

		if (left == right) {
			System.out.println(st);
		} else {
			for (int i = left; i <= right; i++) {
        // left tree
				st = swap(st, left, i); 
        
				findPermutation(st, left + 1, right);
        
        // right tree
				st = swap(st, left, i); 
			}
		}
	}

	private static String swap(String st, int left, int right) {
		char[] c = st.toCharArray();
		char temp = c[left];
		c[left] = c[right];
		c[right] = temp;
		return String.valueOf(c);
	}

}
