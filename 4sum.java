public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i ++) {
			if (i != 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < num.length; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;
				int tar = target - num[i] - num[j];
				for (int k = j + 1, l = num.length - 1; k < l;) {
					if (num[k] + num[l] < tar)
						k++;
					else if (num[k] + num[l] == tar) {
						List<Integer> res = new ArrayList<Integer>(4);
						res.add(num[i]);
						res.add(num[j]);
						res.add(num[k]);
						res.add(num[l]);
						result.add(res);
						k++;
						l--;
						while (k < l && num[k] == num[k - 1])
							k++;
						while (k < l && num[l] == num[l + 1])
							l--;
					}
					else
						l--;
				}
			}
		}
		return result;
	}
}
