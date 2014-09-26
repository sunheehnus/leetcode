public class Solution {
	void swap(int[] num, int pos1, int pos2) {
		int tmp = num[pos1];
		num[pos1] = num[pos2];
		num[pos2] = tmp;
	}
	void build(int[] num, int level, List<List<Integer>> result) {
		if (level >= num.length) {
			List<Integer> res = new LinkedList<Integer>();
			for (int i : num)
				res.add(i);
			result.add(res);
		}
		else {
			for (int i = level; i < num.length; i++) {
				swap(num, level, i);
				build(num, level + 1, result);
				swap(num, level, i);
			}
		}
	}
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		build(num, 0, result);
		return result;
	}
}
