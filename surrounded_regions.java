public class Solution {
	class Node {
		public int x, y;
		public int direction; //0 -> left, 1 -> up, 2 -> right, 3 -> down, 4 -> visited
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			direction = 0;
		}
	}
	class Stack {
		int curpos;
		Node [] stack;
		public Stack(int MAXSIZE) {
			curpos = -1;
			stack = new Node[MAXSIZE];
		}
		public void Push(Node n) {
			stack[++curpos] = n;
		}
		public Node Top() {
			return stack[curpos];
		}
		public void Pop() {
			stack[curpos--] = null;
		}
		public boolean isEmpty() {
			return curpos == -1;
		}
	}
	boolean DFS_surrounded(char[][] board, int y, int x, Stack stack) {
		stack.Push(new Node(x, y));
		boolean state = true;
		while (!stack.isEmpty()) {
			Node cur = stack.Top();
			x = cur.x;
			y = cur.y;
			board[y][x] = 'S';
			if (x == 0 || y == 0 || x == board[0].length - 1 || y == board.length - 1)
				state = false;
			switch (cur.direction++)
			{
				case 0:
					if (x > 0 && board[y][x - 1] == 'O') {
						Node left = new Node(x - 1, y);
						stack.Push(left);
					}
					break;
				case 1:
					if (y > 0 && board[y - 1][x] == 'O') {
						Node up = new Node(x, y - 1);
						stack.Push(up);
					}
					break;
				case 2:
					if (x < board[0].length - 1 && board[y][x + 1] == 'O') {
						Node right = new Node(x + 1, y);
						stack.Push(right);
					}
					break;
				case 3:
					if (y < board.length - 1 && board[y + 1][x] == 'O') {
						Node down = new Node(x, y + 1);
						stack.Push(down);
					}
					break;
				default:
					stack.Pop();
					break;
			}
		}
		return state;
	}
	void DFS_color(char[][] board, int y, int x, char color, Stack stack) {
		stack.Push(new Node(x, y));
		while (!stack.isEmpty()) {
			Node cur = stack.Top();
			x = cur.x;
			y = cur.y;
			board[y][x] = color;
			switch (cur.direction++)
			{
				case 0:
					if (x > 0 && board[y][x - 1] == 'S') {
						Node left = new Node(x - 1, y);
						stack.Push(left);
					}
					break;
				case 1:
					if (y > 0 && board[y - 1][x] == 'S') {
						Node up = new Node(x, y - 1);
						stack.Push(up);
					}
					break;
				case 2:
					if (x < board[0].length - 1 && board[y][x + 1] == 'S') {
						Node right = new Node(x + 1, y);
						stack.Push(right);
					}
					break;
				case 3:
					if (y < board.length - 1 && board[y + 1][x] == 'S') {
						Node down = new Node(x, y + 1);
						stack.Push(down);
					}
					break;
				default:
					stack.Pop();
					break;
			}
		}
	}
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		int x_ceil = board[0].length;
		int y_ceil = board.length;
		Stack stack = new Stack(x_ceil * y_ceil);
		for (int y = 0; y < y_ceil; y++) {
			for (int x = 0; x < x_ceil; x++) {
				if (board[y][x] == 'O')
				{
					if (DFS_surrounded(board, y, x, stack))
						DFS_color(board, y, x, 'X', stack);
				}
			}
		}
		for (int y = 0; y < y_ceil; y++) {
			for (int x = 0; x < x_ceil; x++) {
				if (board[y][x] == 'S')
					DFS_color(board, y, x, 'O', stack);
			}
		}
	}
}
