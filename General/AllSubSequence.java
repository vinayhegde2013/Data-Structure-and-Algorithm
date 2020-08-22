package com.comp.prog;

import java.util.ArrayList;
import java.util.List;

public class AllSubSequence {

	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {

		String str = "ab";
		printAllSubSequence(str, "");
		System.out.println(result);
	}

	private static void printAllSubSequence(String str, String ans) {

		if (str.length() == 0) {
			result.add(ans);
			return;
		}
		
		//Adding a first character
		printAllSubSequence(str.substring(1), ans + str.charAt(0));
		
		//Not adding a first character
		printAllSubSequence(str.substring(1), ans);
	}

}
