public class Solution {
	public int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();
		int[] pre = new int[word2.length()];
		int[] cur = new int[word2.length()];
		for (int i = 0; i < word2.length(); i++)
			cur[i] = i + 1;
		for (int i = 0; i < word1.length(); i++) {
			int[] tmp = pre;
			pre = cur;
			cur = tmp;
			for (int j = 0; j < word2.length(); j++) {
				cur[j] = pre[j] + 1; // delete
				if (j == 0) {
					if (word1.charAt(i) == word2.charAt(j) && i < cur[j]) // same
						cur[j] = i;
					if (word1.charAt(i) != word2.charAt(j) && i + 1 < cur[j]) // replace
						cur[j] = i + 1;
					if (i + 1 + 1 < cur[j]) // insert
						cur[j] = i + 1 + 1;
				}
				else {
					if (word1.charAt(i) == word2.charAt(j) && pre[j - 1] < cur[j]) // same
						cur[j] = pre[j - 1];
					if (word1.charAt(i) != word2.charAt(j) && pre[j - 1] + 1 < cur[j]) // replace
						cur[j] = pre[j - 1] + 1;
					if (cur[j - 1] + 1 < cur[j]) // insert
						cur[j] = cur[j - 1] + 1;
				}
			}
		}
		return cur[word2.length() - 1];
	}
}
