package com.comp.prog;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//We are given a binary tree (with root node root), a target node, and an integer value K.
//Return a list of the values of all nodes that have a distance K from the target node.  
//The answer can be returned in any order.

public class KDistanceTree {

	static Map<TreeNode, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		node.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		System.out.println(findDistanceK(node, node.left, 2));
	}

	public static List<Integer> findDistanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new LinkedList<>();
		findDistanceToTargetFromParent(root, target);
		dfs(root, target, K, map.get(root), res);
		return res;
	}

	private static int findDistanceToTargetFromParent(TreeNode root, TreeNode target) {
		if (root == null)
			return -1;
		if (root == target) {
			map.put(root, 0);
			return 0;
		}
		int left = findDistanceToTargetFromParent(root.left, target);
		if (left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		int right = findDistanceToTargetFromParent(root.right, target);
		if (right >= 0) {
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}

	private static void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
		if (root == null)
			return;
		if (map.containsKey(root))
			length = map.get(root);
		if (length == K)
			res.add(root.val);
		dfs(root.left, target, K, length + 1, res);
		dfs(root.right, target, K, length + 1, res);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
