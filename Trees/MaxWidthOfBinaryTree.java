package com.vinay.hegde.algorithm;

import java.util.*;

public class MaxWidthOfBinaryTree {

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
		System.out.println("Width of Binary Tree: " + widthOfBinaryTree(node));
	}

	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		Map<TreeNode, Integer> m = new HashMap<>();
		q.offer(root);
		m.put(root, 1);
		int curW = 0;
		int maxW = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int start = 0;
			int end = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i == 0)
					start = m.get(node);
				if (i == size - 1)
					end = m.get(node);
				if (node.left != null) {
					m.put(node.left, m.get(node) * 2);
					q.offer(node.left);
				}
				if (node.right != null) {
					m.put(node.right, m.get(node) * 2 + 1);
					q.offer(node.right);
				}
			}
			curW = end - start + 1;
			maxW = Math.max(curW, maxW);
		}
		return maxW;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
