class Solution {
	class Node{
		int num;
		Node next;
	}
	Node stack = null;

	public void push(int value) {
		Node cur = new Node();
		cur.num = value;
		cur.next = stack;
		stack = cur;
	}
	public int pop() {
		int res = stack.num;
		stack = stack.next;
		return res;
	}

	public int eval_onestep(char token, int para1, int para2) {
		switch(token)
		{
			case '+':
				return para1 + para2;
			case '-':
				return para1 - para2;
			case '*':
				return para1 * para2;
			case '/':
				return para1 / para2;
		}
		return -1;
	}
	public int evalRPN(String[] tokens) {
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")) {
				int para2 = pop();
				int para1 = pop();
				push(eval_onestep(tokens[i].charAt(0), para1, para2));
			}
			else
				push(Integer.parseInt(tokens[i]));
		}
		return stack.num;
	}
}
