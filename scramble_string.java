public class Solution {
	public boolean check(char[] c_s1, char[] c_s2, int start_s1, int start_s2, int length, boolean[][][] visited, boolean[][][] isscramble) {
		if (visited[start_s1][start_s2][length])
			return isscramble[start_s1][start_s2][length];
		visited[start_s1][start_s2][length] = true;

		int i1, i2;

		for (i1 = start_s1, i2 = start_s2; i1 - start_s1 < length && c_s1[i1] == c_s2[i2]; i1++, i2++);
		if (i1 - start_s1 >= length)
			return isscramble[start_s1][start_s2][length] = true;
		for (int i = 1; i < length; i++) {
			if (check(c_s1, c_s2, start_s1, start_s2, i, visited, isscramble) && check(c_s1, c_s2, start_s1 + i, start_s2 + i, length - i, visited, isscramble))
				return isscramble[start_s1][start_s2][length] = true;
		}

		for (i1 = start_s1, i2 = start_s2 + length - 1; i1 - start_s1 < length && c_s1[i1] == c_s2[i2]; i1++, i2--);
		if (i1 - start_s1 >= length)
			return isscramble[start_s1][start_s2][length] = true;
		for (int i = 1; i < length; i++) {
			if (check(c_s1, c_s2, start_s1, start_s2 + length - i, i, visited, isscramble) && check(c_s1, c_s2, start_s1 + i, start_s2, length - i, visited, isscramble))
				return isscramble[start_s1][start_s2][length] = true;
		}

		return false;
	}
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char [] c_s1 = s1.toCharArray();
		char [] c_s2 = s2.toCharArray();
		boolean[][][] visited = new boolean[s1.length()][s1.length()][s1.length() + 1];
		boolean[][][] isscramble = new boolean[s1.length()][s1.length()][s1.length() + 1];
		return check(c_s1, c_s2, 0, 0, s1.length(), visited, isscramble);
	}
}
