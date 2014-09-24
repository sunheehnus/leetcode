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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val > l2.val) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
		}
		ListNode result = l1;
		while (l1.next != null && l2 != null) {
			if (l1.next != null && l1.next.val <= l2.val)
				l1 = l1.next;
			else {
				ListNode l2_next = l2.next;
				l2.next = l1.next;
				l1.next = l2;
				l1 = l1.next;
				l2 = l2_next;
			}
		}
		if (l1.next == null)
			l1.next = l2;
		return result;
	}
}
