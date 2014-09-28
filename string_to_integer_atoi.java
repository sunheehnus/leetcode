public class Solution {
	public int atoi(String str) {
		int start_pos;
		for (start_pos = 0; start_pos < str.length() && Character.isSpaceChar(str.charAt(start_pos)); start_pos++);
		if (start_pos >= str.length())
			return 0;
		if (str.charAt(start_pos) == '-') {
			long result = 0;
			for (start_pos++; start_pos < str.length() && Character.isDigit(str.charAt(start_pos)); start_pos++) {
				result *= 10;
				result -= str.charAt(start_pos) - '0';
				if (result <= Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
			return (int) result;
		}
		else if (str.charAt(start_pos) == '+' || Character.isDigit(str.charAt(start_pos))) {
			if (str.charAt(start_pos) == '+')
				start_pos++;
			long result = 0;
			for (; start_pos < str.length() && Character.isDigit(str.charAt(start_pos)); start_pos++) {
				result *= 10;
				result += str.charAt(start_pos) - '0';
				if (result >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			}
			return (int)result;
		}
		return 0;
	}
}
