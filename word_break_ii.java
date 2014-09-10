import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
class Solution {
	boolean [] visit;
	boolean [] isBreak;
	public boolean CheckBreak(String s, Set<String> dict, int pos) {
		boolean res = false;
		if (visit[pos] == true)
			return isBreak[pos];
		visit[pos] = true;
		if (dict.contains(s))
			res = isBreak[pos] = true;
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				if (CheckBreak(s.substring(i, s.length()), dict, pos + i))
					res = isBreak[pos] = true;
			}
		}
		return res;
	}
	public boolean CheckWordBreak(String s, Set<String> dict) {
		visit = new boolean[s.length()];
		isBreak = new boolean[s.length()];
		for (int i = 0; i < s.length(); isBreak[i] = false, visit[i++] = false);
		return CheckBreak(s, dict, 0);
	}

	public void Break(String s, Set<String> dict, String pre, int pos, List<String> res) {
		if (isBreak[pos] == false)
			return;
		if (dict.contains(s)) {
			res.add(pre + (pre.length()==0?"":" ") + s);
		}
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i))) {
				Break(s.substring(i, s.length()), dict, pre + (pre.length()==0?"":" ") + s.substring(0, i), pos + i, res);
			}
		}
	}
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new LinkedList<String>();
		if (CheckWordBreak(s, dict) == false)
			return res;
		Break(s, dict, "", 0, res);
		return res;
	}
}

public class word_break_ii {
	public static void main(String [] args) {
		Solution sol = new Solution();
		String str = "aaaaaaaaaaaaaaaaab";
		//str = "catsanddog";
		Set dict = new HashSet();
		//dict.add("cat");
		//dict.add("cats");
		//dict.add("and");
		//dict.add("sand");
		//dict.add("dog");
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaab");
		System.out.println(sol.wordBreak(str, dict));
	}
}
