public class Solution {
	int total;
	boolean judge(char[][] board, int x, int y) {
		for (int i = x - 1; i >= 0; i--) {
			if (board[i][y] == 'Q')
				return false;
		}
		for (int i = x - 1, j = y - 1; i >=0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		int n = board.length;
		for (int i = x - 1, j = y + 1; i >=0 && j < n; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}
	void build(char[][] board, int level) {
		int n = board.length;
		if (level >= n)
			total++;
		else {
			for (int i = 0; i < n; i++) {
				if (judge(board, level, i)) {
					board[level][i] = 'Q';
					build(board, level + 1);
					board[level][i] = '.';
				}
			}
		}
	}
	public int totalNQueens(int n) {
		total = 0;
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		build(board, 0);
		return total;
	}
}
