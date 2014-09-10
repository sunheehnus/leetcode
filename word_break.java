public class Solution {
	boolean [] visit;
	boolean [] isBreak;
	public boolean Break(String s, Set<String> dict, int pos) {
		if (visit[pos] == true)
			return isBreak[pos];
		visit[pos] = true;
		if (dict.contains(s))
			return isBreak[pos] = true;
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				if (Break(s.substring(i, s.length()), dict, pos + i))
					return isBreak[pos] = true;
			}
		}
		return false;
	}
	public boolean wordBreak(String s, Set<String> dict) {
		visit = new boolean[s.length()];
		isBreak = new boolean[s.length()];
		for (int i = 0; i < s.length(); isBreak[i] = false, visit[i++] = false);
		return Break(s, dict, 0);
	}
}
