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
	public TreeNode buildBST(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode res = new TreeNode(num[mid]);
		res.left = buildBST(num, start, mid - 1);
		res.right = buildBST(num, mid + 1, end);
		return res;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		return buildBST(num, 0, num.length - 1);
	}
}
