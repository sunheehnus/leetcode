public class Solution {
	class DistanceToWord{
		String word;
		int distance;
		public DistanceToWord(String word, int distance) {
			this.word = word;
			this.distance = distance;
		}
	}
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end))
			return 1;
		List<DistanceToWord> queue = new LinkedList<DistanceToWord>();
		queue.add(new DistanceToWord(start, 1));
		if (dict.contains(start) == true)
			dict.remove(start);
		while (queue.size() != 0) {
			DistanceToWord dtw = queue.get(0);
			char [] c_word = dtw.word.toCharArray();
			char [] n_word = dtw.word.toCharArray();
			for (int i = 0; i < c_word.length; i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					if (c_word[i] == j)
						continue;
					n_word[i] = j;
					String nextword = new String(n_word);
					if (nextword.equals(end))
					    return dtw.distance + 1;
					if (dict.contains(nextword)) {
						queue.add(new DistanceToWord(nextword, dtw.distance + 1));
						dict.remove(nextword);
					}
				}
				n_word[i] = c_word[i];
			}
			queue.remove(0);
		}
		return 0;
	}
}
