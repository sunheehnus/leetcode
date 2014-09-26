public class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean[] exist = new boolean[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				exist[j] = false;
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (exist[board[i][j] - '1'] == true)
					return false;
				exist[board[i][j] - '1'] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				exist[j] = false;
			for (int j = 0; j < 9; j++)
			{
				if (board[j][i] == '.')
					continue;
				if (exist[board[j][i] - '1'] == true)
					return false;
				exist[board[j][i] - '1'] = true;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 9; k++)
					exist[k] = false;
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (board[i * 3 + k][j * 3 + l] == '.')
							continue;
						if (exist[board[i * 3 + k][j * 3 + l] - '1'] == true)
							return false;
						exist[board[i * 3 + k][j * 3 + l] - '1'] = true;
					}
				}
			}
		}
		return true;
	}
}
