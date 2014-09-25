public class Solution {
	void rotateRound(int[][] matrix, int level) {
		int length = matrix.length - 2 * level;
		if (length == 1)
			return;
		int x = level, y = level;
		for (int i = 0; i < length - 1; i++) {
			int tmp = matrix[x + i][y + length - 1];
			matrix[x + i][y + length - 1] = matrix[x][y + i];
			matrix[x][y + i] = tmp;
			tmp = matrix[x + length - 1][y + length - 1 - i];
			matrix[x + length - 1][y + length - 1 - i] = matrix[x][y + i];
			matrix[x][y + i] = tmp;
			tmp = matrix[x + length - 1 - i][y];
			matrix[x + length - 1 - i][y] = matrix[x][y + i];
			matrix[x][y + i] = tmp;
		}
	}
	public void rotate(int[][] matrix) {
		for (int level = 0; level * 2 <= matrix.length; level++)
			rotateRound(matrix, level);
	}
}
