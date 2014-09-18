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
	void build_path(TreeNode node, int sum, LinkedList<Integer> path, List<List<Integer>> paths) {
		if (node == null)
			return;
		path.addLast(node.val);
		if (node.left == null && node.right == null) {
			if (sum - node.val == 0) {
				paths.add(new LinkedList<Integer>(path));
			}
		}
		if (node.left != null)
			build_path(node.left, sum-node.val, path, paths);
		if (node.right != null)
			build_path(node.right, sum-node.val, path, paths);
		path.removeLast();
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new LinkedList<List<Integer>>();
		LinkedList<Integer> path = new LinkedList<Integer>();
		build_path(root, sum, path, paths);
		return paths;
	}
}
