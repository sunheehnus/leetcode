public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] pre = new int[obstacleGrid[0].length];
		int[] cur = new int[obstacleGrid[0].length];
		cur[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < obstacleGrid[0].length && cur[i - 1] != 0; i++)
			cur[i] = obstacleGrid[0][i] == 1 ? 0 : 1;
		for (int i = 1; i < obstacleGrid.length; i++) {
			int[] tmp = pre;
			pre = cur;
			cur = tmp;
			if (obstacleGrid[i][0] == 0)
				cur[0] = pre[0];
			else
				cur[0] = 0;
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				cur[j] = 0;
				if (obstacleGrid[i][j] == 0) {
					if (pre[j] > 0)
						cur[j] += pre[j];
					if (cur[j - 1] > 0)
						cur[j] += cur[j - 1];
				}
			}
		}
		return cur[obstacleGrid[0].length - 1];
	}
}
