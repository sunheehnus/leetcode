class Solution {
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
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")) {
				int para2 = stack.getFirst();
				stack.removeFirst();
				int para1 = stack.getFirst();
				stack.removeFirst();
				stack.addFirst(eval_onestep(tokens[i].charAt(0), para1, para2));
			}
			else
				stack.addFirst(Integer.parseInt(tokens[i]));
		}
		int result = stack.getFirst();
		stack.removeFirst();
		return result;
	}
}
