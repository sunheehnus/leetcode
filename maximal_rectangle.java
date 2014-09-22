public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int[][] cnt = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++)
			cnt[matrix.length - 1][i] = matrix[matrix.length - 1][i] - '0';
		for (int i = matrix.length - 2; i >= 0; i--) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					cnt[i][j] = cnt[i + 1][j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < cnt.length; i++) {
			int pre = 0;
			for (int j = 0; j < cnt[0].length; j++) {
				if (cnt[i][j] > pre) {
					int length = cnt[i][j];
					for (int k = j; length > 0 && k < cnt[0].length; k++) {
						if (cnt[i][k] < length)
							length = cnt[i][k];
						if (max < length * (k - j + 1))
							max = length * (k - j + 1);
					}
				}
				pre = cnt[i][j];
			}
		}
		return max;
	}
}
