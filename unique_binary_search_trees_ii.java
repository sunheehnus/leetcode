/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
	void _treecopy(TreeNode node, TreeNode dualnode) {
		dualnode.val = node.val;
		if (node.left != null) {
			dualnode.left = new TreeNode(911103);
			_treecopy(node.left, dualnode.left);
		}
		if (node.right != null) {
			dualnode.right = new TreeNode(911103);
			_treecopy(node.right, dualnode.right);
		}
	}
	TreeNode treecopy(TreeNode root) {
		if (root == null)
			return null;
		TreeNode dualroot = new TreeNode(911103);
		_treecopy(root, dualroot);
		return dualroot;
	}
	List<TreeNode> generate(int[] vals, int start, int end) {
		if (start > end)
			return null;
		List<TreeNode> results = new LinkedList<TreeNode>();
		TreeNode curnode = null;
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generate(vals, start, i - 1);
			List<TreeNode> rights = generate(vals, i + 1, end);
			if (lefts == null && rights == null) {
				results.add(new TreeNode(vals[i]));
				continue;
			}
			if (lefts == null) {
				for (TreeNode right: rights) {
					curnode = new TreeNode(vals[i]);
					curnode.right = right;
					results.add(curnode);
				}
				continue;
			}
			if (rights == null) {
				for (TreeNode left: lefts) {
					curnode = new TreeNode(vals[i]);
					curnode.left = left;
					results.add(curnode);
				}
				continue;
			}
			for (TreeNode left: lefts) {
				for (TreeNode right: rights) {
					curnode = new TreeNode(vals[i]);
					curnode.left = treecopy(left);
					curnode.right = treecopy(right);
					results.add(curnode);
				}
			}
		}
		return results;
	}
	public List<TreeNode> generateTrees(int n) {
	    if (n == 0) {
	        List<TreeNode> result = new LinkedList<TreeNode>();
	        result.add(null);
	        return result;
	    }
		int[] vals = new int[n];
		for (int i = 0; i < n; vals[i] = i + 1, i++);
		return generate(vals, 0, n - 1);
	}
}
