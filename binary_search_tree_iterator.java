/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> route = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            route.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !route.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode stackTop = route.pop();
        if (stackTop.right != null) {
            TreeNode node = stackTop.right;
            while (node != null) {
                route.push(node);
                node = node.left;
            }
        }
        return stackTop.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
