public class Solution {
	void build(String s, int start, int level, List<String> results, List<String> path) {
		if (level > 4) {
			if (start == s.length()) {
				String result = null;
				for (String str: path) {
					if (result == null)
						result = str + '.';
					else
						result += str + '.';
				}
				results.add(result.substring(0, result.length() - 1));
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (start + i > s.length())
				break;
			if (i > 1 && s.charAt(start) == '0')
				break;
			String field = s.substring(start, start + i);
			int field_int = Integer.parseInt(field);
			if (field_int > 255)
				break;
			path.add(field);
			build(s, start + i, level + 1, results, path);
			path.remove(path.size() - 1);
		}
	}
	public List<String> restoreIpAddresses(String s) {
		List<String> results = new LinkedList<String>();
		List<String> path = new LinkedList<String>();
		build(s, 0, 1, results, path);
		return results;
	}
}
