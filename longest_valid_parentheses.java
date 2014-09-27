public class Solution {
	public int longestValidParentheses(String s) {
		int pos = 0;
		boolean[] check = new boolean[s.length()];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stack.isEmpty())
					check[stack.pop()] = true;
				else
					pos++;
			}
			else
				stack.push(pos++);
		}

		int max = 0;
		for (int i = 0; i < pos; i++) {
			if (!check[i])
				continue;
			int j;
			for (j = i; j < pos && check[j]; j++);
			if (max < j - i)
				max = j - i;
			i = j - 1;
		}
		return max * 2;
	}
}
