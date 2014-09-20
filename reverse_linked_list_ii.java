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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m >= n)
			return head;
		ListNode pre = null;
		ListNode cur = head;
		for (int i = 0; i < m; i++) {
			pre = cur;
			cur = cur.next;
		}

		ListNode reverse_pre = null;
		ListNode reverse_next = null;
		for (int i = 0; i <= n - m; i++) {
			reverse_next = cur.next;
			cur.next = reverse_pre;
			reverse_pre = cur;
			cur = reverse_next;
		}

		if (pre == null) {
			head.next = cur;
			head = reverse_pre;
		}
		else {
			pre.next.next = cur;
			pre.next = reverse_pre;
		}
		return head;
	}
}
