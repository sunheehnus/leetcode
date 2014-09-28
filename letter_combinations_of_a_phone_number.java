public class Solution {
	void build(String digits, int pos, char[] res, String[] buttons, List<String> result) {
		if (pos >= digits.length()) {
			result.add(new String(res));
			return;
		}
		String button = buttons[digits.charAt(pos) - '0'];
		for (int i = 0; i < button.length(); i++) {
			res[pos] = button.charAt(i);
			build(digits, pos + 1, res, buttons, result);
		}
	}
	public List<String> letterCombinations(String digits) {
		String[] buttons = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new LinkedList<String>();
		char[] res = new char[digits.length()];
		build(digits, 0, res, buttons, result);
		return result;
	}
}
