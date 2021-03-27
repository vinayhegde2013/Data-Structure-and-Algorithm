package com.comp.prog;

public class Add1ToArray {

	public static void main(String[] args) {

		int[] arr = { 9, 9, 9, 9 };
		recursive(arr, arr.length - 1);
		System.out.println(arr[0]);
		for (int i : arr)
			if (i < arr.length)
				System.out.println(arr[i]);
	}

	private static void recursive(int[] arr, int length) {

    //Algorithm : 
    //If last element is less then 9 , add a
    //else make current element 0 and increment counter and travel recursively.
		if (length != -1) {
			if (arr[length] < 9) {
				arr[length] = arr[length] + 1;
				return;
			}

			arr[length] = 0;
			length--;
			recursive(arr, length);
		}
	}

}
