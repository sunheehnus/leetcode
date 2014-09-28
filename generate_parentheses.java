public class Solution {
	void build(char[] res, int left_out, int right_out, int pos, List<String> result) {
		if (left_out == 0 && right_out == 0) {
			result.add(new String(res));
			return;
		}
		if (left_out < 0 || right_out < 0 || left_out > right_out)
			return;
		res[pos] = '(';
		build(res, left_out - 1, right_out, pos + 1, result);
		res[pos] = ')';
		build(res, left_out, right_out - 1, pos + 1, result);
	}
	void build(int n, List<String> result) {
		char[] res = new char[n * 2];
		int left_out = n, right_out = n;
		build(res, left_out, right_out, 0, result);
	}
	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<String>();
		if (n == 0)
			return result;
		build(n, result);
		return result;
	}
}
