public class Solution {
	class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	boolean[] findExistNums(char[][] board, int x, int y) {
		boolean[] exist = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][y] != '.')
				exist[board[i][y] - '1'] = true;
			if (board[x][i] != '.')
				exist[board[x][i] - '1'] = true;
		}
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
				if (board[i][j] != '.')
					exist[board[i][j] - '1'] = true;
			}
		}
		return exist;
	}
	boolean build(char[][] board, Pos[] dots, int pos, int cnt) {
		if (pos >= cnt)
			return true;
		int x = dots[pos].x;
		int y = dots[pos].y;
		boolean[] exist = findExistNums(board, x, y);
		for (int i = 0; i < 9; i++) {
			if (exist[i] == false) {
				board[x][y] = (char)(i + '1');
				if (build(board, dots, pos + 1, cnt))
					return true;
			}
		}
		board[x][y] = '.';
		return false;
	}
	public void solveSudoku(char[][] board) {
		Pos[] dots = new Pos[81];
		int cnt = 0;
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					dots[cnt++] = new Pos(i, j);
			}
		}
		build(board, dots, 0, cnt);
	}
}
