public class Solution {
	void roundUp(int[][] matrix, int x, int y, int length, int start) {
		for (int i = 0; i < length; i++)
			matrix[x][y + i] = start++;
		for (int i = 1; i < length; i++)
			matrix[x + i][y + length - 1] = start++;
		for (int i = 1; i < length; i++)
			matrix[x + length - 1][y + length - 1 - i] = start++;
		for (int i = 1; i < length - 1; i++)
			matrix[x + length - 1 - i][y] = start++;
	}
	public int[][] generateMatrix(int n) {
		int x, y, length, start;
		int[][] matrix = new int[n][n];
		for (x = 0, y = 0, start = 1, length = n; length > 0; x++, y++, start += 4 * length - 4, length -= 2)
			roundUp(matrix, x, y, length, start);
		return matrix;
	}
}
