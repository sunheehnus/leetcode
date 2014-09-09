import java.util.ArrayList;
import java.util.List;
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
	void preordervisit(TreeNode node, List<Integer> ans) {
		if (node == null)
			return;
		ans.add(node.val);
		if (node.left != null)
			preordervisit(node.left, ans);
		if (node.right != null)
			preordervisit(node.right, ans);
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		preordervisit(root, ans);
		return ans;
	}
}
