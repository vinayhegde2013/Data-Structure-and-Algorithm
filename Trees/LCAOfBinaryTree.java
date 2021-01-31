package com.vinay.hegde.algorithm;

public class LCAOfBinaryTree {

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
		System.out.println("LCA is :" + lowestCommonAncestor(node, node.left, node.right).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		if (left == null && right == null) {
			return null;
		}

		return left != null ? left : right;
	}

// 	private TreeNode helper(TreeNode node, TreeNode q, TreeNode p) {
//         if (node == null || node == q || node == p) {
//             return node;
//         } else {
//             TreeNode left = helper(node.left, p, q);
//             TreeNode right = helper(node.right, p, q);
//             if (left != null && right != null) {
//                 return node;
//             }
//             return left != null ? left : right;
//         }
		
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
