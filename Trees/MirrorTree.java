package com.vinay.hegde.algorithm;

public class MirrorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(4);
		treeNode.right = new TreeNode(2);
		treeNode.right.left = new TreeNode(4);
		treeNode.right.right = new TreeNode(3);
		System.out.println(isMirrorTree(treeNode, treeNode));

	}

	private static boolean isMirrorTree(TreeNode leftTreeNode, TreeNode rightTreeNode) {
		if (leftTreeNode == null && rightTreeNode == null)
			return true;
		if (leftTreeNode != null && rightTreeNode != null && leftTreeNode.val == rightTreeNode.val) {
			return isMirrorTree(leftTreeNode.left, rightTreeNode.right)
					&& isMirrorTree(leftTreeNode.right, rightTreeNode.left);
		}
		return false;
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
