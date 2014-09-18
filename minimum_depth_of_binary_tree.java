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
	int mindepth = 911103;
	void find_depth(TreeNode node, int level) {
		if (node.left == null && node.right == null) {
			mindepth = mindepth > level ? level : mindepth;
			return;
		}
		if (node.left != null)
			find_depth(node.left, level + 1);
		if (node.right != null)
			find_depth(node.right, level + 1);
	}
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		find_depth(root, 1);
		return mindepth;
	}
}
