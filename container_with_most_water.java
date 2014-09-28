public class Solution {
	int min(int a, int b) {
		return a > b ? b : a;
	}
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int pre = Integer.MIN_VALUE;
		for (int i = 0; i < height.length - 1; i++) {
			if (height[i] <= pre)
				continue;
			for (int j = height.length - 1; j > i; j--) {
				if (min(height[i], height[j]) * (j - i) > max)
					max = min(height[i], height[j]) * (j - i);
				if (height[j] >= height[i])
					break;
			}
			pre = height[i];
		}
		return max;
	}
}
