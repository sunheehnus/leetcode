/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Node {
        TreeLinkNode father, child;
        Node(TreeLinkNode father, TreeLinkNode child) {
            this.father = father;
            this.child = child;
        }
    }
    Node nextLevelStartPoint;
    public void findNextLevelStartPoing(Node curPoint) {
        if (nextLevelStartPoint == null) {
            if (curPoint.child.left != null)
                nextLevelStartPoint = new Node(curPoint.child, curPoint.child.left);
            else if (curPoint.child.right != null)
                nextLevelStartPoint = new Node(curPoint.child, curPoint.child.right);
        }
    }
    public Node nextNode(TreeLinkNode father, TreeLinkNode child) {
        if (child == father.left) {
            if (father.right != null)
                return new Node(father, father.right);
        }
        TreeLinkNode n = father.next;
        while (n != null && n.left == null && n.right == null)
            n = n.next;
        if (n == null)
            return null;
        else if (n.left != null)
            return new Node(n, n.left);
        else
            return new Node(n, n.right);
    }
    public void _connect() {
        Node curPoint = nextLevelStartPoint;
        Node nextPoint = nextNode(curPoint.father, curPoint.child);
        nextLevelStartPoint = null;
        while (nextPoint != null) {
            findNextLevelStartPoing(curPoint);
            curPoint.child.next = nextPoint.child;
            curPoint = nextPoint;
            nextPoint = nextNode(curPoint.father, curPoint.child);
        }
        curPoint.child.next = null;
        findNextLevelStartPoing(curPoint);
    }
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        root.next = null;
        findNextLevelStartPoing(new Node(null, root));
        while (nextLevelStartPoint != null) {
            _connect();
        }
    }
}
