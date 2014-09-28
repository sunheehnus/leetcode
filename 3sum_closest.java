public class Solution {
	int abs(int x) {
		return x > 0 ? x : -x;
	}
	public int threeSumClosest(int[] num, int target) {
		int closest = num[0] + num[1] + num[2];
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1, k = num.length - 1; j < k;) {
				int cur = num[i] + num[j] + num[k];
				if (abs(cur - target) < abs(closest - target))
					closest = cur;
				if (cur < target)
					j++;
				else if (cur > target)
					k--;
				else
					return target;
			}
		}
		return closest;
	}
}
