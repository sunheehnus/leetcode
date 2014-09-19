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
	TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
		if (instart > inend)
			return null;
		TreeNode curnode;
		int shift;
		for (shift = 0; preorder[prestart] != inorder[instart + shift]; shift++);
		curnode = new TreeNode(inorder[instart + shift]);
		curnode.left = build(preorder, prestart + 1, prestart + shift, inorder, instart, instart + shift - 1);
		curnode.right = build(preorder, prestart + shift + 1, preend, inorder, instart + shift + 1, inend);
		return curnode;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
}
