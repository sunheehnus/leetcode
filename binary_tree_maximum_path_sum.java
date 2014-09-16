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
		int max = Integer.MIN_VALUE;
	}
	int find_maxsum(TreeNode node, Result res) {
		if (node == null)
			return 0;
		int l_maxpathsum = find_maxsum(node.left, res);
		int r_maxpathsum = find_maxsum(node.right, res);
		int max_child = l_maxpathsum > r_maxpathsum ? l_maxpathsum : r_maxpathsum;
		max_child = max_child > 0 ? max_child : 0;
		int cur = node.val;
		if (l_maxpathsum > 0)
			cur += l_maxpathsum;
		if (r_maxpathsum > 0)
			cur += r_maxpathsum;
		if (cur > res.max)
			res.max = cur;
		return max_child + node.val;
	}
	public int maxPathSum(TreeNode root) {
		Result res = new Result();
		find_maxsum(root, res);
		return res.max;
	}
}
