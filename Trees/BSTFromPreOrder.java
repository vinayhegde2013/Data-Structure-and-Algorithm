package com.comp.prog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTFromPreOrder {

	static int index = 0;

	public static void main(String[] args) {

		TreeNode treeNode = constructBSTUtil(new int[] { 8, 5, 1, 7, 10, 12 });
		printInOrder(treeNode);
		System.out.println(printLevelOrder(treeNode));
	}

	private static List<Integer> printLevelOrder(TreeNode treeNode) {

		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		q.offer(treeNode);
		while (!q.isEmpty()) {
			TreeNode currNode = q.poll();
			if (currNode != null) {
				res.add(currNode.val);
				if (currNode.left != null)
					q.offer(currNode.left);
				if (currNode.right != null)
					q.offer(currNode.right);
			}
		}
		return res;
	}

	private static TreeNode constructBSTUtil(int[] preOrder) {
		return constructBST(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TreeNode constructBST(int[] preOrder, int minValue, int maxValue) {

		if (index >= preOrder.length)
			return null;

		TreeNode root = null;
		if (preOrder[index] > minValue && preOrder[index] < maxValue) {
			root = new TreeNode(preOrder[index++]);
			root.left = constructBST(preOrder, minValue, root.val);
			root.right = constructBST(preOrder, root.val, maxValue);
		}

		return root;
	}

	private static void printInOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printInOrder(treeNode.left);
		System.out.println(treeNode.val);
		printInOrder(treeNode.right);
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
