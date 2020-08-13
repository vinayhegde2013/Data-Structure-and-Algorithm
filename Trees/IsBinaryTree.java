package com.comp.prog;

public class IsBinarySearchTree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		System.out.println(isBinarySearchUtil(node));
	}

	private static boolean isBinarySearchUtil(TreeNode node) {
		return isBinarySearch(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearch(TreeNode node, int minValue, int maxValue) {

		if (node == null)
			return true;
		if (node.val < minValue || node.val > maxValue)
			return false;
		return isBinarySearch(node.left, minValue, node.val - 1) && isBinarySearch(node.right, node.val + 1, maxValue);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
