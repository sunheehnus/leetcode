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
	TreeNode pre = null;
	boolean judge(TreeNode node) {
		if (node.left != null && judge(node.left) == false)
			return false;
		if (pre != null) {
			if (pre.val >= node.val)
				return false;
		}
		pre = node;
		if (node.right != null && judge(node.right) == false)
			return false;
		return true;
	}
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return judge(root);
	}
}
