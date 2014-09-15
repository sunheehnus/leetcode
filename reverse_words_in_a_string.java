public class Solution {
	public String reverseWords(String s) {
		if (s.length() == 0)
			return s;
		char [] c_s = s.toCharArray();
		int ceil, floor;
		for (floor = 0; floor < c_s.length && (c_s[floor] == ' ' || c_s[floor] == '\t'); floor++);
		for (ceil = c_s.length - 1; ceil >= 0 && (c_s[ceil] == ' ' || c_s[ceil] == '\t'); ceil--);
		if (floor > ceil)
			return "";
		for (int i = 0; i < c_s.length; i++) {
			if (c_s[i] == ' ' || c_s[i] == '\t')
				c_s[i] = ' ';
		}
		int length = 0;
		for (int j = floor; j < ceil; j++) {
			if (c_s[j] == ' ' && c_s[j + 1] == ' ')
				continue;
			c_s[length++] = c_s[j];
		}
		c_s[length++] = c_s[ceil];
		for (int i = 0, j = 0; j < length; i = j)
		{
			for (j = i; j < length && c_s[j] != ' '; j++);
			for (int l1 = i, l2 = j - 1; l1 < l2; l1++, l2--) {
				c_s[l1] ^= c_s[l2];
				c_s[l2] ^= c_s[l1];
				c_s[l1] ^= c_s[l2];
			}
			j++;
		}
		for (int i = 0, j = length - 1; i < j; i++, j--) {
				c_s[i] ^= c_s[j];
				c_s[j] ^= c_s[i];
				c_s[i] ^= c_s[j];
		}
		return new String(c_s, 0, length);
	}
	public static void main(String [] args) {
		Solution sol = new Solution();
		System.out.println(sol.reverseWords("a"));
	}
}
