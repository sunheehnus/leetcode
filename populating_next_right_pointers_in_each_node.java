/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void _connect(TreeLinkNode root) {
        if (root != null) {
            if (root.left != null)
                root.left.next = root.right;
            if (root.right != null)
                root.right.next = root.next != null ? root.next.left : null;
            _connect(root.left);
            _connect(root.right);
        }
	}
	public void connect(TreeLinkNode root) {
        if (root != null)
            root.next = null;
        _connect(root);
    }
}
