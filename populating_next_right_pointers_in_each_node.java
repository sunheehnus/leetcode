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
		int depth = 0;
		while (root != null) {
			root = root.left;
			depth++;
		}
		return depth;
	}
	void traverse_ID(TreeLinkNode node, int level, int ID) {
		if (level < ID) {
			traverse_ID(node.left, level + 1, ID);
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
