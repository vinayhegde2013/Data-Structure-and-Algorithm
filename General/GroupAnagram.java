package com.comp.prog;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	static Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) {

		List<String> l = new ArrayList<>();
		l.add("Abc");
		l.add("bca");
		l.add("Daily");
		l.add("dial");
		l.add("Elbow");
		l.add("Below");
		l.add("lebow");

		groupAnagram(l);

		map.entrySet().forEach(k -> {
			System.out.println(k.getKey() + " - " + k.getValue());
		});
	}

	public static void groupAnagram(List<String> anagramList) {

		if (nonNull(anagramList) && !anagramList.isEmpty()) {
			for (int i = 0; i < anagramList.size(); i++) {

				char[] c = anagramList.get(i).toLowerCase().toCharArray();
				Arrays.sort(c);
				if (map.containsKey(String.valueOf(c))) {
					map.get(String.valueOf(c)).add(String.valueOf(anagramList.get(i)));
				} else {
					List<String> intermidiateList = new ArrayList<>();
					intermidiateList.add(String.valueOf(anagramList.get(i)));
					map.put(String.valueOf(c), intermidiateList);
				}
			}
		}
	}

}
