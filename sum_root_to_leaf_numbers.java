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
	class Result {
		int res;
		public Result() {
			res = 0;
		}
	}
	void sum(TreeNode node, int prefix, Result res) {
		if (node == null)
			return;
		if (node.val == 0)
			prefix *= 10;
		else
			for (int val = node.val; val != 0; prefix *= 10, val /= 10);
		prefix += node.val;
		if (node.left == null && node.right == null)
			res.res += prefix;
		else {
			sum(node.left, prefix, res);
			sum(node.right, prefix, res);
		}
	}
	public int sumNumbers(TreeNode root) {
		Result res = new Result();
		sum(root, 0, res);
		return res.res;
	}
}
