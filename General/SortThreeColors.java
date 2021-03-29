package com.comp.prog;

public class SortThreeColors {

	public static void main(String[] args) {
		int a[] = { 2, 1, 0, 1, 2, 2, 1, 0, 2, 1 };
		Sort(a);
	}

	private static void Sort(int[] a) {
		int count0 = 0, count1 = 0, count2 = 0;
		for (int i = 0; i < a.length; i++) {
			switch (a[i]) {
			case 0:
				count0++;
				break;
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			default:
				break;
			}
		}

		int i = 0;
		while (count0 > 0) {
			a[i++] = 0;
			count0--;
		}
		while (count1 > 0) {
			a[i++] = 1;
			count1--;
		}
		while (count2 > 0) {
			a[i++] = 2;
			count2--;
		}
		for (int j = 0; j < a.length; j++)
			System.out.print(a[j]);
	}

}
