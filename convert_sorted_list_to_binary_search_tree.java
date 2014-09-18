/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
	public TreeNode buildBST(ListNode head, ListNode rear) {
		if (head == null || rear == null)
			return null;
		ListNode mid = head, premid = null;
		for (ListNode end = head;;premid = mid, mid = mid.next) {
			end = end.next;
			if (end == rear.next)
				break;
			end = end.next;
			if (end == rear.next)
				break;
		}
		TreeNode res = new TreeNode(mid.val);
		res.left = mid != head ? buildBST(head, premid) : null;
		res.right = mid != rear ? buildBST(mid.next, rear) : null;
		return res;
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode rear;
		for (rear = head; rear.next != null; rear = rear.next);
		return buildBST(head, rear);
	}
}
