package com.vinay.hegde.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class GoogleKickStart2020RoundAAllocation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int attempt = 0;
		while (T-- > 0) {
			attempt++;
			s.nextLine();
			String[] st = s.nextLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int B = Integer.parseInt(st[1]);
			int cost[] = new int[N];
			for (int i = 0; i < N; i++)
				cost[i] = s.nextInt();

			Arrays.sort(cost);
			int ans = 0;
			int count = 0;
			for (int i = 0; i < cost.length; i++) {
				if ((ans + cost[i]) > ans && ans <= B && (ans + cost[i]) <= B) {
					ans = (ans + cost[i]);
					count++;
				}
			}
			System.out.println("Case #" + attempt + ": " + count);
		}

	}

}
