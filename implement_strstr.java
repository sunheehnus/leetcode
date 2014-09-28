public class Solution {
	int[] findNext(String pattern) {
		int[] next = new int[pattern.length() + 1];
		next[0] = -1;
		for (int i = 1, j = 0; i < pattern.length(); i++) {
			if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				if (pattern.charAt(i) == pattern.charAt(j))
					next[i] = next[j];
				else
					next[i] = j;
			}
			else
				j = next[j];
		}
		return next;
	}
	int KMPSearch(String content, String pattern) {
		int[] next = findNext(pattern);
		int i, j;
		for (i = 0, j = 0; i < content.length() && j < pattern.length(); i++) {
			if (j == -1 || content.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			else
				j = next[j];
		}
		return j >= pattern.length() ? i - j : -1;
	}
	public String strStr(String haystack, String needle) {
		if (haystack.length() == 0 || needle.length() == 0)
			return haystack;
		int pos = KMPSearch(haystack, needle);
		if (pos == -1)
			return null;
		else
			return haystack.substring(pos);
	}
}

