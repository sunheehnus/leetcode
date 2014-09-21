public class Solution {
	void build_res(int [] build, int [] set, List<List<Integer>> result) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < set.length; i ++) {
			for (int j = 0; j < build[i]; j ++)
				res.add(set[i]);
		}
		result.add(res);
	}
	void next(int [] build, int [] cnts) {
		build[0]++;
		for (int i = 0; i < cnts.length && build[i] > cnts[i]; i++) {
			build[i] = 0;
			if (i + 1 < cnts.length)
				build[i + 1] ++;
		}
	}
	public List<List<Integer>> subsetsWithDup(int[] num) {
		int [] sorted_num = new int[num.length];
		for (int i = 0; i < num.length; i++)
			sorted_num[i] = num[i];
		Arrays.sort(sorted_num);
		int kinds = 1;
		for (int pre = 0, cur = 1; cur < num.length; cur++) {
			if (sorted_num[pre] == sorted_num[cur])
				continue;
			pre = cur;
			kinds++;
		}
		int [] set = new int[kinds];
		int [] cnts = new int[kinds];
		set[0] = sorted_num[0];
		cnts[0] = 1;
		for (int pre = 0, cur = 1, curpos = 0; cur < num.length; cur++) {
			if (sorted_num[pre] == sorted_num[cur]) {
				cnts[curpos]++;
				continue;
			}
			pre = cur;
			curpos++;
			cnts[curpos]++;
			set[curpos] = sorted_num[cur];
		}
		int total = 1;
		for (int i = 0; i < cnts.length; i++)
			total *= cnts[i] + 1;
		int [] build = new int[cnts.length];
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		for (int i = 0; i < total; i++) {
			build_res(build, set, result);
			next(build, cnts);
		}
		return result;
	}
}
