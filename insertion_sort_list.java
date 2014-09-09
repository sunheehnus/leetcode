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
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
	public void insertsort_list(ListNode head) {
	}
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode floorNode, ceilNode, maxNode, dummy_Node, preceilNode;
		for (ceilNode = head; ceilNode.next != null; ceilNode = ceilNode.next);
		for (floorNode = head; ceilNode != floorNode; ceilNode = preceilNode) {
			maxNode = ceilNode;
			preceilNode = null;
			for (dummy_Node = floorNode; dummy_Node != ceilNode; dummy_Node = dummy_Node.next) {
				preceilNode = dummy_Node;
				if (dummy_Node.val > maxNode.val)
					maxNode = dummy_Node;
			}
			int tmp = ceilNode.val;
			ceilNode.val = maxNode.val;
			maxNode.val = tmp;
		}
		return head;
	}
}
