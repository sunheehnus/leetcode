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
	void build(Queue<TreeNode> nodes, Queue<Integer> nodes_level, List<List<Integer>> result) {
		LinkedList<Integer> res = null;
		int level = 0;
		while (nodes.isEmpty() == false) {
			TreeNode node = nodes.poll();
			int node_level = nodes_level.poll();
			if (node_level != level) {
				level = node_level;
				res = new LinkedList<Integer>();
				result.add(res);
			}
			if ((level & 1) == 1)
				res.addLast(node.val);
			else
				res.addFirst(node.val);
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> nodes_level = new LinkedList<Integer>();
		nodes.add(root);
		nodes_level.add(1);
		build(nodes, nodes_level, result);
		return result;
	}
}
