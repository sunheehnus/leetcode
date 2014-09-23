public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = 0, col = 0;
		while (col < matrix[0].length && matrix[row][col] <= target)
			col++;
		col--;
		if (col == -1)
			return false;
		while (row < matrix.length && matrix[row][col] < target)
			row++;
		if (row == matrix.length)
			return false;
		for (; col >= 0 && matrix[row][col] > target; col--);
		return col >= 0 && matrix[row][col] == target;
	}
}
