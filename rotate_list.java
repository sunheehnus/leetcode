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
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0)
			return head;
		int length = 0;
		for (ListNode node = head; node != null && length < n; node = node.next, length++);
		if (length < n)
			n %= length;

		if (n == 0)
			return head;
		ListNode l1, l2;
		for (l1 = head, l2 = head; n > 0; l2 = l2.next, n--);
		if (l2 == null)
			return head;
		while (l2.next != null) {
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode tmp = l1.next;
		l1.next = null;
		l2.next = head;
		head = tmp;
		return head;
	}
}
