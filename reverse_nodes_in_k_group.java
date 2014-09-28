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
	ListNode reverse(ListNode head) {
		ListNode pre, cur, next;
		for (pre = null, cur = head; cur != null;) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode pre = null, cur = head, next;
		while (true) {
			for (int i = 1; cur != null && i < k; i++, cur = cur.next);
			if (cur == null)
				break;
			next = cur.next;
			cur.next = null;

			if (pre == null) {
				pre = head;
				head = reverse(head);
				pre.next = next;
				cur = next;
			}
			else {
				ListNode tmp = pre.next;
				pre.next = reverse(tmp);
				tmp.next = next;
				pre = tmp;
				cur = next;
			}
		}
		return head;
	}
}
