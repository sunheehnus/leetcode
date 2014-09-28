public class Solution {
	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '(':
					stack.push(1);
					break;
				case '[':
					stack.push(2);
					break;
				case '{':
					stack.push(3);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != 1)
						return false;
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != 2)
						return false;
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != 3)
						return false;
					break;
			}
		}
		return stack.isEmpty();
	}
}
