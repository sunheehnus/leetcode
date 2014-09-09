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
	void postordervisit(TreeNode node, List<Integer> ans) {
		if (node == null)
			return;
		if (node.left != null)
			postordervisit(node.left, ans);
		if (node.right != null)
			postordervisit(node.right, ans);
		ans.add(node.val);
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		postordervisit(root, ans);
		return ans;
	}
}
