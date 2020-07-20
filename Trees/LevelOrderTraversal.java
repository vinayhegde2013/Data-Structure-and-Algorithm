package com.comp.prog;

import java.util.*;

public class LevelOrderTraversal {

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
		System.out.println(printOrder(node));

	}

	private static List<Integer> printOrder(TreeNode node) {
		Queue<TreeNode> tree = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		tree.offer(node);
		while (!tree.isEmpty()) {
			TreeNode ele = tree.poll();
			if (ele != null) {
				res.add(ele.val);
				if (ele.left != null)
					tree.offer(ele.left);
				if (ele.right != null)
					tree.offer(ele.right);
			}
		}
		return res;

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
