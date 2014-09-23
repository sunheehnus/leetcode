public class Solution {
	void addOneResult(int[] S, int[] num, List<List<Integer>> results) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 1)
				res.add(S[i]);
		}
		results.add(res);
	}
	void inc(int[] num) {
		num[0]++;
		for (int i = 0; num[i] > 1; i++) {
			num[i] = 0;
			num[i+1]++;
		}
	}
	boolean isEnd(int[] num) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 1)
				return false;
		}
		return true;
	}
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (S.length == 0)
			return results;
		Arrays.sort(S);
		int[] num = new int[S.length];
		while (true) {
			addOneResult(S, num, results);
			if (isEnd(num))
				break;
			inc(num);
		}
		return results;
	}
}
