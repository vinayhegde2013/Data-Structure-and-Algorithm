

package com.comp.prog;

import java.util.Deque;
import java.util.HashMap;

/**
 * @author Vinay Hegde
 *
 */
public class LRUCache {

	private static final int CAPACITY = 100;
	static Deque<Integer> dq;
	static HashMap<Integer, Integer> map = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		put(1, 3);
		get(1);
		put(2, 4);
		put(5, 2);
		get(2);
	}

	public static int get(int key) {
		if (!map.containsKey(key))
			return -1;
		else {
			dq.remove(key);
			dq.addFirst(key);
			return map.get(key);
		}
	}

	public static void put(int key, int value) {
		if (map.containsKey(key)) {
			dq.remove(key);
			dq.addFirst(key);
		} else {
			if (dq.size() == CAPACITY) {
				int lkey = dq.removeLast();
				map.remove(lkey);
			}
			dq.addFirst(key);
		}

		map.put(key, value);
	}

}
