public class Solution {
	void roundUp(int[][] matrix, int x, int y, int m, int n, List<Integer> result) {
		if (m == 1) {
			for (int i = 0; i < n; i++)
				result.add(matrix[x][y + i]);
		}
		else if (n == 1) {
			for (int i = 0; i < m; i++)
				result.add(matrix[x + i][y]);
		}
		else {
			for (int i = 0; i < n; i++)
				result.add(matrix[x][y + i]);
			for (int i = 1; i < m; i++)
				result.add(matrix[x + i][y + n - 1]);
			for (int i = 1; i < n; i++)
				result.add(matrix[x + m - 1][y + n - 1 - i]);
			for (int i = 1; i < m - 1; i++)
				result.add(matrix[x + m - 1 - i][y]);
		}
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return result;
		int x, y, m, n;
		for (x = 0, y = 0, m = matrix.length, n = matrix[0].length; m > 0 && n > 0; x++, y++, m -= 2, n -= 2)
			roundUp(matrix, x, y, m, n, result);
		return result;
	}
}
