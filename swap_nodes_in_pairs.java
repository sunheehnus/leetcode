/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode pre = null, cur = head, next;
		while (cur != null && cur.next != null) {
			next = cur.next.next;
			if (pre == null) {
				head = cur.next;
				head.next = cur;
			}
			else {
				pre.next = cur.next;
				pre.next.next = cur;
			}
			cur.next = next;
			pre = cur;
			cur = pre.next;
		}
		return head;
	}
}
