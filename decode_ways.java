public class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[] result = new int[s.length()];
		if (s.charAt(0) == '0')
			return 0;
		result[0] = 1;
		for (int i = 1; i < s.length(); i ++) {
			char pre = s.charAt(i - 1);
			char cur = s.charAt(i);
			if ((pre == '0' || pre > '2') && cur == '0')
				return 0;
			if (cur == '0')
				result[i] = i > 2 ? result[i - 2] : 1;
			else if (pre == '0')
				result[i] = i > 2 ? result[i - 1] : 1;
			else {
				result[i] = result[i - 1];
				if (pre == '1' || pre == '2' && cur <= '6')
					result[i] += i > 1 ? result[i - 2] : 1;
			}
		}
		return result[s.length() - 1];
	}
}
