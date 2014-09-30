public class Solution {
	public int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[Character.MAX_VALUE + 1];
		int start, end;
		int max = 0;
		for (start = -1, end = 0; end < s.length(); end ++) {
			if (exist[s.charAt(end)]) {
				while (s.charAt(++start) != s.charAt(end))
					exist[s.charAt(start)] = false;
			}
			else {
				exist[s.charAt(end)] = true;
				if (end - start > max)
					max = end - start;
			}
		}
		return max;
	}
}
