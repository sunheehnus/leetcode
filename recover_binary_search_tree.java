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
	TreeNode pos1 = null;
	TreeNode pos2 = null;
	boolean pos1_found = false;
	void inorder_traversal(TreeNode node) {
		if (node == null)
			return;
		inorder_traversal(node.left);
		if (pre != null) {
			if (node.val < pre.val) {
				if (pos1_found == false) {
					pos1 = pre;
					pos2 = node;
					pos1_found = true;
				}
				else
					pos2 = node;
			}
		}
		pre = node;
		inorder_traversal(node.right);
	}
	public void recoverTree(TreeNode root) {
		inorder_traversal(root);
		pos1.val ^= pos2.val;
		pos2.val ^= pos1.val;
		pos1.val ^= pos2.val;
	}
}
