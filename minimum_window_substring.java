public class Solution {
	public String minWindow(String S, String T) {
		if (S.length() == 0 || T.length() == 0 || S.length() < T.length())
			return "";

		int length = T.length();
		boolean[] exist = new boolean[256];
		int[] cnt = new int[256];
		int[] cur_cnt = new int[256];
		for (int i = 0; i < T.length(); i++) {
			exist[T.charAt(i)] = true;
			cnt[T.charAt(i)]++;
		}

		int start, end, floor, ceil;
		for (floor = 0; floor < S.length() && exist[S.charAt(floor)] == false; floor++);
		start = floor;
		end = S.length();
		for (ceil = floor; ceil < S.length(); ceil++) {
			if (exist[S.charAt(ceil)] == true && cur_cnt[S.charAt(ceil)] < cnt[S.charAt(ceil)])
					length--;
			cur_cnt[S.charAt(ceil)]++;
			while (cur_cnt[S.charAt(floor)] > cnt[S.charAt(floor)]) {
				cur_cnt[S.charAt(floor)]--;
				floor ++;
			}
			if (length == 0 && ceil - floor < end - start) {
				start = floor;
				end = ceil;
			}
		}
		if (length == 0)
			return S.substring(start, end + 1);
		return "";
	}
}
