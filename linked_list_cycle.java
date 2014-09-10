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
    public boolean hasCycle(ListNode head) {
	    ListNode node1, node2;
	    for (node1 = node2 = head;;) {
		    if (node2 == null || node2.next == null)
			    return false;
		    node2 = node2.next.next;
		    node1 = node1.next;
		    if (node1 == node2) {
			    return true;
		    }
	    }
    }
}
