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
	void build(LinkedList<List<Integer>> result, Queue<TreeNode> nodes, Queue<Integer> nodes_level) {
		int level = 0;
		while (nodes.isEmpty() == false) {
			TreeNode node = nodes.poll();
			int node_level = nodes_level.poll();
			if (node_level != level) {
				level = node_level;
				result.addFirst(new LinkedList<Integer>());
			}
			result.getFirst().add(node.val);
			if (node.left != null) {
				nodes.add(node.left);
				nodes_level.add(level + 1);
			}
			if (node.right != null) {
				nodes.add(node.right);
				nodes_level.add(level + 1);
			}
		}
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> nodes_level = new LinkedList<Integer>();
		nodes.add(root);
		nodes_level.add(1);
		build(result, nodes, nodes_level);
		return result;
	}
}
