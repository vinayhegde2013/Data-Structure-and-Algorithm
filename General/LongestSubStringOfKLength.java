package com.comp.prog;

public class LongestSubStringOfKLength {

	public static void main(String[] args) {
    
            System.out.println(findLongestSubstringOfKLength("abcbdbdbbdcdabd", 2));
	}

	static String findLongestSubstringOfKLength(String str, int k) {
		int end = 0, begin = 0;

		Set<Character> window = new HashSet<>();

		int[] freq = new int[256];

		for (int low = 0, high = 0; high < str.length(); high++) {
			window.add(str.charAt(high));
			freq[str.charAt(high)]++;

			while (window.size() > k) {
				if (--freq[str.charAt(low)] == 0) {
					window.remove(str.charAt(low));
				}

				low++;
			}

			if (end - begin < high - low) {
				end = high;
				begin = low;
			}
		}

		return str.substring(begin, end + 1);
	}

}
