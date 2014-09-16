public class Solution {
	public boolean isPalindrome(String s) {
		char [] c_s = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (c_s[i] >= 'a' && c_s[i] <= 'z')
			c_s[i] &= 0xDF;
		}
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			if (c_s[i] >= 'A' && c_s[i] <= 'Z' || c_s[i] >= '0' && c_s[i] <= '9')
				c_s[length++] = c_s[i];
		}
		for (int i = 0, j = length - 1; i < j; i++, j--) {
			if (c_s[i] != c_s[j])
				return false;
		}
		return true;
	}
}
