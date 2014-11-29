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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA, lengthB;
        ListNode tailA, tailB;
        for (lengthA = 0, tailA = headA; tailA.next != null; tailA = tailA.next, lengthA++);
        for (lengthB = 0, tailB = headB; tailB.next != null; tailB = tailB.next, lengthB++);
        if (tailA != tailB)
            return null;
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA --;
        }
        while (lengthA < lengthB) {
            headB = headB.next;
            lengthB --;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
