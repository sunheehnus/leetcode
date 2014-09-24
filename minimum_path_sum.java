public class Solution {
	int min(int a, int b) {
		return a > b ? b : a;
	}
	public int minPathSum(int[][] grid) {
		int[] pre = new int[grid[0].length];
		int[] cur = new int[grid[0].length];
		cur[0] = grid[0][0];
		for (int i = 1; i < grid[0].length; i++)
			cur[i] = cur[i - 1] + grid[0][i];
		for (int i = 1; i < grid.length; i++) {
			int[] tmp = pre;
			pre = cur;
			cur = tmp;
			cur[0] = pre[0] + grid[i][0];
			for (int j = 1; j < grid[0].length; j++)
				cur[j] = min(cur[j - 1], pre[j]) + grid[i][j];
		}
		return cur[grid[0].length - 1];
	}
}
