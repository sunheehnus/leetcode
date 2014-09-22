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
		while (head != null && head.next != null && head.next.val == head.val) {
			int val = head.val;
			while (head != null && head.val == val)
				head = head.next;
		}
		if (head == null)
			return head;
		for (ListNode dummy_node = head; dummy_node != null;) {
			if (dummy_node.next != null && dummy_node.next.next != null && dummy_node.next.val == dummy_node.next.next.val) {
				int val = dummy_node.next.val;
				while (dummy_node.next != null && dummy_node.next.val == val)
					dummy_node.next = dummy_node.next.next;
			}
			else
				dummy_node = dummy_node.next;
		}
		return head;
	}
}
