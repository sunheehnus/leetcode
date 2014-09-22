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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		for (ListNode dummy_node = head; dummy_node != null && dummy_node.next != null;) {
			if (dummy_node.next != null && dummy_node.next.val == dummy_node.val)
				dummy_node.next = dummy_node.next.next;
			else
				dummy_node = dummy_node.next;
		}
		return head;
	}
}
