public class Solution {
	int factorial(int n) {
		int result = 1;
		for (; n > 0; n--)
			result *= n;
		return result;
	}
	void build(int[] result, int level, int left) {
		if (level >= result.length)
			return;
		int leap = factorial(result.length - level - 1);
		int pos;
		for (pos = level; pos < result.length && left > leap; pos++)
			left -= leap;
		int num = result[pos];
		for (int i = pos - 1; i >= level; i--)
			result[i + 1] = result[i];
		result[level] = num;
		build(result, level + 1, left);
	}
	public String getPermutation(int n, int k) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
			result[i] = i + 1;
		build(result, 0, k);
		String res = "";
		for (int i = 0; i < n; i++)
			res += result[i];
		return res;
	}
}
