package com.comp.prog;

public class BSTFromPreOrder {

	static int index = 0;

	public static void main(String[] args) {

		TreeNode treeNode = constructBSTUtil(new int[] { 8, 5, 1, 7, 10, 12 });
		printTree(treeNode);
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

	 //In order traversal
	private static void printTree(TreeNode treeNode) {
       
		if (treeNode == null)
			return;

		printTree(treeNode.left);
		System.out.println(treeNode.val);
		printTree(treeNode.right);
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
