public class Solution {
	public int lengthOfLastWord(String s) {
		int floor, ceil;
		for (ceil = s.length() - 1; ceil >= 0 && s.charAt(ceil) == ' '; ceil--);
		if (ceil < 0)
			return 0;
		for (floor = ceil; floor >= 0 && s.charAt(floor) != ' '; floor--);
		return ceil - floor;
	}
}
