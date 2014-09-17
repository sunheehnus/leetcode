/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		TreeNode node = new TreeNode(911103);
		node.right = root.left;
		root.left = node;
		while (node.right != null)
			node = node.right;
		node.right = root.right;
		root.right = root.left.right;
		root.left = null;
	}
}
