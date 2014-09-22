public class Solution {
	public int largestRectangleArea(int[] height) {
		if (height.length == 0)
			return 0;
		int[] pre = new int[height.length];

		int[] left = new int[height.length];
		pre[0] = -1;
		left[0] = height[0];
		for (int i = 1; i < height.length; i ++) {
			if (height[i] <= height[i - 1]) {
				int k = i - 1;
				while (k >= 0 && height[k] >= height[i])
					k = pre[k];
				pre[i] = k;
			}
			else
				pre[i] = i - 1;
			left[i] = height[i] * (i - pre[i]);
		}
		int[] right = new int[height.length];
		pre[height.length - 1] = height.length;
		right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i --) {
			if (height[i] <= height[i + 1]) {
				int k = i + 1;
				while (k < height.length && height[k] >= height[i])
					k = pre[k];
				pre[i] = k;
			}
			else
				pre[i] = i + 1;
			right[i] = height[i] * (pre[i] - i);
		}

		int max = 0;

		for (int i = 0; i < height.length; i++) {
			if (left[i] + right[i] - height[i] > max)
				max = left[i] + right[i] - height[i];
		}
		return max;
	}
}
