package com.vinay.hegde.algorithm;

import java.util.Scanner;

public class GoogleKickStartRecordBreaker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, n, i, max, curr, prev, count;
		t = sc.nextInt();
		int attempt = 0;
		while (t-- > 0) {
			attempt++;
			n = sc.nextInt();
			max = count = 0;
			prev = sc.nextInt();
			for (i = 0; i < n - 1; i++) {
				curr = sc.nextInt();
				if (prev > max) {
					max = prev;
					if (curr < prev)
						count++;
				}
				prev = curr;
			}
			if (prev > max)
				count++;
			System.out.println("Case #" + attempt + ": " + count);
		}
	}
}
