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
    public int meet_step(ListNode head) {
	    int step = 0;
	    ListNode node1, node2;
	    for (node1 = node2 = head;;) {
		    step ++;
		    if (node2 == null || node2.next == null)
			    return -1;
		    node2 = node2.next.next;
		    node1 = node1.next;
		    if (node1 == node2) {
			    return step;
		    }
	    }
    }
    public ListNode detectCycle(ListNode head) {
	    int step = meet_step(head);
	    if (step == -1)
		    return null;
	    ListNode node1, node2;
	    node1 = head;
	    node2 = head;
	    while (step > 0) {
		    node2 = node2.next;
		    step--;
	    }
	    while (node1 != node2) {
		    node1 = node1.next;
		    node2 = node2.next;
	    }
	    return node1;
    }
}
