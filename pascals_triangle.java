public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> p_triangle = new LinkedList<List<Integer>>();
		if (numRows == 0)
			return p_triangle;
		List<Integer> top = new LinkedList<Integer>();
		top.add(1);
		p_triangle.add(top);
		for (int i = 1; i < numRows; i++) {
			List<Integer> cur_line = new LinkedList<Integer>();
			cur_line.add(1);
			List<Integer> pre_line = p_triangle.get(i - 1);
			int pre = -1;
			for (int cur: pre_line)
			{
				if (pre != -1)
					cur_line.add(pre + cur);
				pre = cur;
			}
			cur_line.add(1);
			p_triangle.add(cur_line);
		}
		return p_triangle;
	}
}
