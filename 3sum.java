public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i != 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1, k = num.length - 1; j < k;) {
				int cur = num[i] + num[j] + num[k];
				if (cur < 0)
					j++;
				else if (cur > 0)
					k--;
				else {
					List<Integer> res = new ArrayList<Integer>(3);
					res.add(num[i]);
					res.add(num[j]);
					res.add(num[k]);
					result.add(res);
					j++;
					k--;
					while (j < k && num[j] == num[j - 1])
						j++;
					while (j < k && num[k] == num[k + 1])
						k--;
				}
			}
		}
		return result;
	}
}
