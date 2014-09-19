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
	void traversal(TreeNode node, List<Integer> result) {
		if (node == null)
			return;
		traversal(node.left, result);
		result.add(node.val);
		traversal(node.right, result);
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		traversal(root, result);
		return result;
	}
}
