public class Solution {
	public String countAndSay(int n) {
		String pre, cur;
		cur = "1";
		while (--n > 0) {
			pre = cur;
			cur = "";
			for (int i = 0, j = 0; i < pre.length(); i = j) {
				for (j = i + 1; j < pre.length() && pre.charAt(j) == pre.charAt(i); j++);
				cur += j - i;
				cur += pre.charAt(i);
			}
		}
		return cur;
	}
}
