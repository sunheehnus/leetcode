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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode result = new ListNode(l1.val + l2.val);
		int carry = result.val / 10;
		result.val %= 10;
		l1 = l1.next;
		l2 = l2.next;

		ListNode cur = result;
		while (l1 != null && l2 != null) {
			ListNode tmp = new ListNode(l1.val + l2.val + carry);
			cur.next = tmp;
			cur = tmp;
			carry = cur.val / 10;
			cur.val = cur.val % 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			ListNode tmp = new ListNode(l1.val + carry);
			cur.next = tmp;
			cur = tmp;
			carry = cur.val / 10;
			cur.val %= 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode tmp = new ListNode(l2.val + carry);
			cur.next = tmp;
			cur = tmp;
			carry = cur.val / 10;
			cur.val %= 10;
			l2 = l2.next;
		}
		if (carry != 0) {
			ListNode tmp = new ListNode(carry);
			cur.next = tmp;
		}
		return result;
	}
}
