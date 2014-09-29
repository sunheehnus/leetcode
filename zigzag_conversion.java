public class Solution {
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		String result = "";
		for (int i = 0, j = 0; i < nRows; i++) {
			for (j = i; j < s.length(); j += 2 * (nRows - 1)) {
				result += s.charAt(j);
				if (i != 0 && i != nRows - 1) {
					if (j + (nRows - 1 - i) * 2 < s.length())
						result += s.charAt(j + (nRows - 1 - i) * 2);
				}
			}
		}
		return result;
	}
}
