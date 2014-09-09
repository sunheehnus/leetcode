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
class Solution {
    public void swapval(ListNode x, ListNode y)
	{
		int tmp;
		tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}
	public void oneway_quicksort_list(ListNode head, ListNode rear)
	{
		if (head == null || rear == null || head == rear)
			return;
		ListNode prefloorNode = null;
		ListNode floorNode = head, ceilNode = head;
		boolean is_sorted = true;
		while (ceilNode != rear)
		{
			if (ceilNode.val > ceilNode.next.val)
				is_sorted = false;
			if (ceilNode.val <= rear.val)
			{
				swapval(floorNode, ceilNode);
				prefloorNode = floorNode;
				floorNode = floorNode.next;
			}
			ceilNode = ceilNode.next;
		}
		if (is_sorted)
			return;
		swapval(floorNode, ceilNode);
		if (floorNode != head)
			oneway_quicksort_list(head, prefloorNode);
		if (floorNode != rear)
			oneway_quicksort_list(floorNode.next, rear);
	}
	public ListNode sortList(ListNode head) {
		ListNode rear = head;
		if (head == null)
		    return head;
		while (rear.next != null)
			rear = rear.next;
		oneway_quicksort_list(head, rear);
		return head;
	}
}
