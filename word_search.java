public class Solution {
	boolean judge(char[][] board, String word, int word_pos, boolean[][] visited, int row, int row_cnt, int col, int col_cnt) {
		if (word_pos >= word.length())
			return true;

		if (board[row][col] != word.charAt(word_pos))
			return false;
		if (word_pos == word.length() - 1)
			return true;

		visited[row][col] = true;
		if (col > 0 && !visited[row][col - 1] && judge(board, word, word_pos + 1, visited, row, row_cnt, col - 1, col_cnt))
			return true;
		if (row > 0 && !visited[row - 1][col] && judge(board, word, word_pos + 1, visited, row - 1, row_cnt, col, col_cnt))
			return true;
		if (col < col_cnt - 1 && !visited[row][col + 1] && judge(board, word, word_pos + 1, visited, row, row_cnt, col + 1, col_cnt))
			return true;
		if (row < row_cnt - 1 && !visited[row + 1][col] && judge(board, word, word_pos + 1, visited, row + 1, row_cnt, col, col_cnt))
			return true;
		visited[row][col] = false;
		return false;
	}
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0)
			return false;
		int row_cnt = board.length;
		int col_cnt = board[0].length;
		boolean visited[][] = new boolean[row_cnt][col_cnt];
		for (int i = 0; i < row_cnt; i++) {
			for (int j = 0; j < col_cnt; j++) {
				if (judge(board, word, 0, visited, i, row_cnt, j, col_cnt))
					return true;
			}
		}
		return false;
	}
}
