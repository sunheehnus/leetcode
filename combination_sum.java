public class Solution {
	void build(int[] candidates, int pos, int target, List<Integer> res, List<List<Integer>> results) {
		if (target == 0) {
			results.add(new LinkedList<Integer>(res));
			return;
		}
		for (;pos < candidates.length && candidates[pos] <= target; pos++) {
			res.add(candidates[pos]);
			build(candidates, pos, target - candidates[pos], res, results);
			res.remove(res.size() - 1);
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (candidates.length == 0)
			return results;
		Arrays.sort(candidates);
		List<Integer> res = new LinkedList<Integer>();
		build(candidates, 0, target, res, results);
		return results;
	}
}
