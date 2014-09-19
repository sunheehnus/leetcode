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
	TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if (instart > inend)
			return null;
		TreeNode curnode;
		if (inorder[instart] == postorder[poststart]) {
			curnode = build(inorder, instart + 1, inend, postorder, poststart + 1, postend);
			if (curnode == null)
				curnode = new TreeNode(inorder[instart]);
			else {
				TreeNode left_bottom = curnode;
				while (left_bottom.left != null)
					left_bottom = left_bottom.left;
				left_bottom.left = new TreeNode(inorder[instart]);
			}
			return curnode;
		}
		int shift;
		for (shift = 0; inorder[instart] != postorder[poststart + shift]; shift++);
		curnode = new TreeNode(inorder[instart]);
		curnode.right = build(inorder, instart + 1, instart + shift, postorder, poststart, poststart + shift - 1);
		if (instart + shift == inend)
			return curnode;
		else{
			TreeNode curfather = build(inorder, instart + shift + 1, inend, postorder, poststart + shift + 1, postend);
			TreeNode left_bottom = curfather;
			while (left_bottom.left != null)
				left_bottom = left_bottom.left;
			left_bottom.left = curnode;
			return curfather;
		}
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
}
