public class Solution {
	String findPrefix(String str1, String str2) {
		int length;
		for (length = 0; length < str1.length() && length < str2.length() && str1.charAt(length) == str2.charAt(length); length++);
		return str1.substring(0, length);
	}
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (String str : strs)
			prefix = findPrefix(prefix, str);
		return prefix;
	}
}
