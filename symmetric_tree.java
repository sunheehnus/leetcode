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
	boolean traversal(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		if (traversal(left.right, right.left) == false)
			return false;
		if (traversal(left.left, right.right) == false)
			return false;
		return true;
	}
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return traversal(root.left, root.right);
	}
}
