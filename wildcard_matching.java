public class Solution {
	public boolean isMatch(String s, String p) {
		int sPos, pPos, starNext = -1;
		for (sPos = pPos = 0; sPos < s.length();) {
			if (pPos < p.length() && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '?')) {
				sPos++;
				pPos++;
			}
			else if (pPos < p.length() && p.charAt(pPos) == '*')
				starNext = ++pPos;
			else if (starNext != -1) {
				sPos -= pPos - starNext - 1;
				pPos = starNext;
			}
			else
				return false;
		}
		while (pPos < p.length() && p.charAt(pPos) == '*')
			pPos++;
		return pPos == p.length();
	}
}
