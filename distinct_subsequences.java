public class Solution {
	public int numDistinct(String S, String T) {
		if (S == null || S.length() < T.length())
			return 0;
		int [] pre = new int[S.length()];
		int [] cur = new int[S.length()];
		cur[0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
		for (int i = 1; i < S.length(); i++) {
			cur[i] = cur[i - 1];
			if (S.charAt(i) == T.charAt(0))
				cur[i]++;
		}
		for (int i = 1; i < T.length(); i++) {
			int [] dummy_exchange = cur;
			cur = pre;
			pre = dummy_exchange;
			for (int j = 0; j < S.length(); j++) {
				if (j < i)
					cur[j] = 0;
				else {
					cur[j] = cur[j - 1];
					if (S.charAt(j) == T.charAt(i))
						cur[j] += pre[j - 1];
				}
			}
		}
		return cur[S.length() - 1];
	}
}
