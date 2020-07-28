package com.vinay.hegde.algorithm;

import java.util.*;
public class TreeFromInOrderAndPostOrder {

	static int p;

	public static void main(String[] args) {

		int[] inOrder = new int[] { 9,3,15,20,7};
		int[] postOrder = new int[] { 9,15,7,20,3};
		System.out.println(buildTree(inOrder, postOrder));
	}

	private static TreeNode buildTree(int[] inOrder, int[] postOrder) {
		if (inOrder.length != postOrder.length)
			return null;
		int start = 0;
		p = inOrder.length - 1;
		Map<Integer, Integer> inorderValeToIdxMap = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			inorderValeToIdxMap.put(inOrder[i], i);
		}
		return treeUtil(inOrder, postOrder, start, p, inorderValeToIdxMap);

	}

	private static TreeNode treeUtil(int[] inOrder, int[] postOrder, int start, int end,
			Map<Integer, Integer> inorderValeToIdxMap) {
		if (start > end)
			return null;
		int curr = postOrder[end];
		end--;
		TreeNode treeNode = new TreeNode(curr);
		int index = inorderValeToIdxMap.get(curr).intValue();
		if (end == start)
			return treeNode;
		treeNode.right = treeUtil(inOrder, postOrder, index + 1, end, inorderValeToIdxMap);
		treeNode.left = treeUtil(inOrder, postOrder, start, index - 1, inorderValeToIdxMap);
		return treeNode;
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
