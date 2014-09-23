public class Solution {
	void addOneResult(int[] num, List<List<Integer>> results) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 1)
				res.add(i + 1);
		}
		results.add(res);
	}
	void init(int[] num, int k) {
		for (int i = 0; i < k; i++)
			num[i] = 1;
	}
	void inc(int[] num) {
		int floor, ceil;
		for (floor = 0; num[floor] != 1; floor++);
		for (ceil = floor; num[ceil] == 1; ceil++);
		num[ceil] = 1;
		for (int i = floor; i < ceil; i++)
			num[i] = 0;
		for (int i = 0; i < ceil - floor - 1; i++)
			num[i] = 1;
	}
	boolean isEnd(int[] num, int k) {
		for (int i = num.length - k; i < num.length; i++) {
			if (num[i] != 1)
				return false;
		}
		return true;
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (n < k || n == 0)
			return results;
		int[] num = new int[n];
		init(num, k);
		while (true) {
			addOneResult(num, results);
			if (isEnd(num, k))
				break;
			inc(num);
		}
		return results;
	}
}
