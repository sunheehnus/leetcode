public class Solution {
	void build(int[] candidates, int pos, int target, List<Integer> res, List<List<Integer>> results) {
		if (target == 0) {
			results.add(new LinkedList<Integer>(res));
			return;
		}
		for (int i = 0; pos + i < candidates.length && candidates[pos + i] <= target; i++) {
			if (i > 0 && candidates[pos + i - 1] == candidates[pos + i])
				continue;
			res.add(candidates[pos + i]);
			build(candidates, pos + i + 1, target - candidates[pos + i], res, results);
			res.remove(res.size() - 1);
		}
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (candidates.length == 0)
			return results;
		Arrays.sort(candidates);
		List<Integer> res = new LinkedList<Integer>();
		build(candidates, 0, target, res, results);
		return results;
	}
}
