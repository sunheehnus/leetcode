public class Solution {
	boolean isMatch(String s, int s_pos, String p, int p_pos) {
		if (s_pos >= s.length() && p_pos >= p.length())
			return true;
		if (p_pos >= p.length())
			return false;
		if (s_pos >= s.length()) {
			for (;p_pos + 1 < p.length(); p_pos += 2) {
				if (p.charAt(p_pos + 1) != '*')
					break;
			}
			return p_pos >= p.length();
		}
		if (p_pos < p.length() - 1 && p.charAt(p_pos + 1) == '*') {
			if (p.charAt(p_pos) == '.') {
				for (int i = 0; i + s_pos <= s.length(); i++) {
					if (isMatch(s, i + s_pos, p, p_pos + 2))
						return true;
				}
				return false;
			}
			else {
				int i;
				for (i = 0; i + s_pos < s.length(); i++) {
					if (s.charAt(i + s_pos) != p.charAt(p_pos))
						break;
					if (isMatch(s, i + s_pos, p, p_pos + 2))
						return true;
				}
				return isMatch(s, i + s_pos, p, p_pos + 2);
			}
		}
		else if(p.charAt(p_pos) == '.' || s.charAt(s_pos) == p.charAt(p_pos))
			return isMatch(s, s_pos + 1, p, p_pos + 1);
		return false;
	}
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}
}
