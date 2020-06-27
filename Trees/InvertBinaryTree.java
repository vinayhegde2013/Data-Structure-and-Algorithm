package com.vinay.hegde.algorithm;

/**
 * -----------Problem Statement----------- 
 * Visit - https://leetcode.com/problems/invert-binary-tree/
 Input:

    4
  /   \
 2     7
/ \   / \
1   3 6   9

Output:
    4
  /   \
 7     2
/ \   / \
9   6 3   1
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		else
			return invert(root);

	}

	public TreeNode invert(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode left = invert(node.left);
		TreeNode right = invert(node.right);

		node.left = right;
		node.right = left;
		return node;
	}

	public class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int value) {
			this.value = value;
		}

		TreeNode(int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}