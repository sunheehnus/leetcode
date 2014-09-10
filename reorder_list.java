/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode reverse(ListNode l) {
		ListNode pre, cur, next;
		if (l == null)
			return l;
		pre = null;
		cur = l;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	public void reorder(ListNode l1, ListNode l2) {
		ListNode l1_cur, l1_next, l2_cur, l2_next;
		for (l1_cur = l1, l2_cur = l2; l2_cur != null; l1_cur = l1_next, l2_cur = l2_next)
		{
			l1_next = l1_cur.next;
			l2_next = l2_cur.next;
			l1_cur.next = l2_cur;
			l2_cur.next = l1_next;
		}
	}
	public void reorderList(ListNode head) {
		ListNode l1_head, l2_head, l1_end, tmp;
		if (head == null || head.next == null)
			return;
		for (l1_end = tmp = head; ;)
		{
			tmp = tmp.next;
			if (tmp == null)
				break;
			tmp = tmp.next;
			if (tmp == null)
				break;
			l1_end = l1_end.next;
		}
		l1_head = head;
		l2_head = l1_end.next;
		l1_end.next = null;
		l2_head = reverse(l2_head);
		reorder(l1_head, l2_head);
	}
}
