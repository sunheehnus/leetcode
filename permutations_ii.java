public class Solution {
	void swap(int[] num, int pos1, int pos2) {
		int tmp = num[pos1];
		num[pos1] = num[pos2];
		num[pos2] = tmp;
	}
	void build(int[] num, int level, List<List<Integer>> result) {
		if (level >= num.length) {
			List<Integer> res = new ArrayList<Integer>(num.length);
			for (int i : num)
				res.add(i);
			result.add(res);
		}
		else {
			for (int i = level, j = 0; i < num.length; i++) {
				for (j = level; j < i && num[j] != num[i]; j++);
				if (j < i)
					continue;
				swap(num, level, i);
				build(num, level + 1, result);
				swap(num, level, i);
			}
		}
	}
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		build(num, 0, result);
		return result;
	}
}
