public class Solution {
	boolean []visit;
	int [] min;
	boolean isPalindrome(String str) {
		char [] chars = str.toCharArray();
		for (int i = 0; i < chars.length>>1; i++) {
			if (chars[i] != chars[chars.length - i - 1])
				return false;
		}
		return true;
	}
	int findmin(String s, int cur) {
		if (s.length() == 0)
			return 0;
		if (visit[cur])
			return min[cur];
		visit[cur] = true;
		int curmin = Integer.MAX_VALUE;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (isPalindrome(s.substring(0, i + 1))) {
				int rear_min = findmin(s.substring(i + 1, s.length()), cur + i + 1);
				if (rear_min + 1 < curmin)
					curmin = rear_min + 1;
				if (rear_min <= 1)
					break;
			}
		}
		return min[cur] = curmin;
	}
	public int minCut(String s) {
		visit = new boolean[s.length()];
		min = new int[s.length()];
		return findmin(s, 0) - 1;
	}
}
