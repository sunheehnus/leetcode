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
	class Heap {
		ListNode[] heap;
		int size;
		public Heap(List<ListNode> list) {
			size = list.size();
			heap = new ListNode[size + 1];
			int i = 1;
			for (ListNode node : list)
				heap[i++] = node;
			for (i = size / 2; i >= 1; i--)
				maintain(i);
		}
		void swap(int pos1, int pos2) {
			ListNode node = heap[pos1];
			heap[pos1] = heap[pos2];
			heap[pos2] = node;
		}
		boolean isEmpty() {
			return size == 0;
		}
		void maintain(int pos) {
			while (true) {
				int minpos = pos;
				if (pos * 2 <= size && heap[pos * 2].val < heap[minpos].val)
					minpos = pos * 2;
				if (pos * 2 + 1 <= size && heap[pos * 2 + 1].val < heap[minpos].val)
					minpos = pos * 2 + 1;
				if (minpos == pos)
					return;
				swap(pos, minpos);
				pos = minpos;
			}
		}
		int getMinVal() {
			int minval = heap[1].val;
			heap[1] = heap[1].next;
			if (heap[1] == null) {
				swap(1, size--);
			}
			maintain(1);
			return minval;
		}
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		List<ListNode> listsWithoutNull = new LinkedList<ListNode>();
		for (ListNode node : lists) {
			if (node != null)
				listsWithoutNull.add(node);
		}
		if (listsWithoutNull.size() == 0)
			return null;
		Heap heap = new Heap(listsWithoutNull);
		ListNode head = null, pre = null;
		while (!heap.isEmpty()) {
			ListNode node = new ListNode(heap.getMinVal());
			if (pre == null) {
				head = node;
				pre = node;
			}
			else {
				pre.next = node;
				pre = node;
			}
		}
		return head;
	}
}
