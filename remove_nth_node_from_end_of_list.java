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
    public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode node1, node2;
	    for (node2 = head; n > 0; node2 = node2.next, n--);
	    if (node2 == null)
		    return head.next;
	    for (node1 = head; node2.next != null; node1 = node1.next, node2 = node2.next);
	    node1.next = node1.next.next;
	    return head;
    }
}
