/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode h1, h2, res;
		if (head == null)
			return null;
		for (h1 = head; h1 != null;) {
			h2 = new RandomListNode(h1.label);
			h2.next = h1.next;
			h1.next = h2;
			h1 = h2.next;
		}
		for (h1 = head; h1 != null; h1 = h2.next) {
			h2 = h1.next;
			if (h1.random == null)
				h2.random = null;
			else
				h2.random = h1.random.next;
		}
		for (h1 = head, h2 = head.next, res = h2; h1 != null; h1 = h1.next, h2 = h2.next) {
			h1.next = h2.next;
			h2.next = h1.next == null ? null : h1.next.next;
		}
		return res;
	}
}
