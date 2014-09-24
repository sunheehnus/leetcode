public class Solution {
	public int uniquePaths(int m, int n) {
		int[] pre = new int[n];
		int[] cur = new int[n];
		cur[0] = 1;
		for (int i = 0; i < n; i++)
			cur[i] = 1;
		for (int i = 1; i < m; i++) {
			int[] tmp = pre;
			pre = cur;
			cur = tmp;
			cur[0] = 1;
			for (int j = 1; j < n; j++)
				cur[j] = pre[j] + cur[j - 1];
		}
		return cur[n - 1];
	}
}
