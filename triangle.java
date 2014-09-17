public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int [] pres = new int[triangle.size()];
		int [] minimums = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> pres_list = triangle.get(i);
			int length = 0;
			for (int pre: pres_list) {
				pres[length++] = pre;
			}
			for (int j = 0; j < length; j++) {
				pres[j] += minimums[j] > minimums[j + 1] ? minimums[j + 1] : minimums[j];
			}
			int [] dummy_exchange;
			dummy_exchange = minimums;
			minimums = pres;
			pres = dummy_exchange;
		}
		return minimums[0];
	}
}
