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
	public ListNode partition(ListNode head, int x) {
		ListNode prefix_head, prefix_end, suffix_head, suffix_end;
		for (prefix_head = null, prefix_end = null, suffix_head = null, suffix_end = null; head != null; head = head.next) {
			if (head.val < x) {
				if (prefix_head == null)
					prefix_head = head;
				else
					prefix_end.next = head;
				prefix_end = head;
			}
			else {
				if (suffix_head == null)
					suffix_head = head;
				else
					suffix_end.next = head;
				suffix_end = head;
			}
		}
		if (prefix_end != null)
			prefix_end.next = suffix_head;
		if (suffix_end != null)
			suffix_end.next = null;
		return prefix_head != null ? prefix_head : suffix_head;
	}
}
