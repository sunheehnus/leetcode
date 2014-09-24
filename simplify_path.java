public class Solution {
	public String simplifyPath(String path) {
		String[] path_array = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < path_array.length; i++) {
			if (path_array[i].length() == 0 || path_array[i].equals("."))
				continue;
			else if (path_array[i].equals("..")) {
				if (!stack.empty())
					stack.pop();
			}
			else
				stack.push(path_array[i]);
		}
		String result = "";
		while (!stack.empty()) {
			result = "/" + stack.pop() + result;
		}
		return result.length() == 0 ? "/" : result;
	}
}
