public class Solution {
	boolean isPalindrome(String str) {
		char [] chars = str.toCharArray();
		for (int i = 0; i < chars.length>>1; i++) {
			if (chars[i] != chars[chars.length - i - 1])
				return false;
		}
		return true;
	}
	void build(String s, int cur, List<String> one_res_building, List<List<String>> res) {
		if (s.length() == 0) {
			res.add(new LinkedList<String>(one_res_building));
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i + 1))) {
				one_res_building.add(s.substring(0, i + 1));
				build(s.substring(i + 1, s.length()), cur + i + 1, one_res_building, res);
				one_res_building.remove(one_res_building.size() - 1);
			}
		}
	}
	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<List<String>>();
		build(s, 0, new LinkedList<String>(), res);
		return res;
	}
}
