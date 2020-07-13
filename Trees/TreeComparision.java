package com.vinay.hegde.algorithm;

import com.vinay.hegde.algorithm.LCAOfBinaryTree.TreeNode;

public class TreeComparision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		node.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);

		TreeNode node1 = new TreeNode(3);
		node1.left = new TreeNode(5);
		node1.left.left = new TreeNode(6);
		node1.left.right = new TreeNode(2);
		node1.left.right.left = new TreeNode(7);
		node1.left.right.right = new TreeNode(4);
		node1.right = new TreeNode(1);
		node1.right.left = new TreeNode(0);
		node1.right.right = new TreeNode(8);
		System.out.println(compare(node, node1));
	}

	private static boolean compare(TreeNode firstNode, TreeNode secondNode) {
		if (firstNode == null && secondNode == null)
			return true;
		if (firstNode == null || secondNode == null)
			return false;
		if (firstNode.val != secondNode.val)
			return false;
		return compare(firstNode.right, secondNode.right) && compare(secondNode.left, secondNode.left);
	}
}
