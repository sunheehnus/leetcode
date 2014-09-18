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
	class balanced_depth {
		boolean balanced;
		int depth;
		public balanced_depth(boolean balanced, int depth) {
			this.balanced = balanced;
			this.depth = depth;
		}
	}
	public balanced_depth balanced_with_depth(TreeNode node) {
		if (node == null)
			return new balanced_depth(true, 0);
		balanced_depth left = balanced_with_depth(node.left);
		if (left.balanced == false)
			return left;
		balanced_depth right = balanced_with_depth(node.right);
		if (right.balanced == false)
			return right;
		int max_depth = left.depth > right.depth ? left.depth : right.depth;
		int min_depth = left.depth <= right.depth ? left.depth : right.depth;
		return new balanced_depth(max_depth - min_depth <= 1, max_depth + 1);
	}
	public boolean isBalanced(TreeNode root) {
		return balanced_with_depth(root).balanced;
	}
}
