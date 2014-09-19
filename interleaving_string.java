public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean [][] available = new boolean[s1.length() + 1][s2.length() + 1];
		available[0][0] = true;
		for (int length = 1; length <= s3.length(); length++) {
			for (int s1_length = length, s2_length = 0; s1_length >= 0; s1_length--, s2_length++) {
				if (s1_length > s1.length() || s2_length > s2.length())
					continue;
				if (s2_length != 0) {
					if (available[s1_length][s2_length - 1] == true && s2.charAt(s2_length - 1) == s3.charAt(length - 1))
						available[s1_length][s2_length] |= true;
					else
						available[s1_length][s2_length] |= false;
				}
				if (s1_length != 0) {
					if (available[s1_length - 1][s2_length] == true && s1.charAt(s1_length - 1) == s3.charAt(length - 1))
						available[s1_length][s2_length] |= true;
					else
						available[s1_length][s2_length] |= false;
				}
			}
		}
		return available[s1.length()][s2.length()];
	}
}
