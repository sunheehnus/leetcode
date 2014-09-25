public class Solution {
	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int pre = 0;
		for (int i = 0; i < A.length; i++) {
			if (pre + A[i] > max)
				max = pre + A[i];
			pre = pre + A[i] > 0 ? pre + A[i] : 0;
		}
		return max;
	}
}
