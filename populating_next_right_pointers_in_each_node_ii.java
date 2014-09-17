/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	TreeLinkNode pre;
	int get_depth(TreeLinkNode root) {
		if (root == null)
			return 0;
		int l_length = get_depth(root.left);
		int r_length = get_depth(root.right);
		return (l_length > r_length ? l_length : r_length) + 1;
	}
	void traverse_ID(TreeLinkNode node, int level, int ID) {
		if (level < ID) {
			if (node.left != null)
				traverse_ID(node.left, level + 1, ID);
			if (node.right != null)
				traverse_ID(node.right, level + 1, ID);
		}
		else {
			if (pre != null)
				pre.next = node;
			pre = node;
		}
	}
	public void connect(TreeLinkNode root) {
		int depth = get_depth(root);
		for (int i = 0; i < depth; i++) {
			pre = null;
			traverse_ID(root, 0, i);
			pre.next = null;
		}
	}
}
