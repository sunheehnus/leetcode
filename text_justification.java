public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new LinkedList<String>();
		int floor, ceil;
		for (floor = 0; floor < words.length; floor = ceil) {
			int left = L + 1;
			for (ceil = floor; ceil < words.length && words[ceil].length() + 1 <= left; ceil++)
					left -= words[ceil].length() + 1;
			if (ceil == words.length || ceil == floor + 1) {
				String res = words[floor++];
				while (floor < ceil)
					res += " " + words[floor++];
				for (int i = 0; i < left; i++)
					res += " ";
				result.add(res);
			}
			else {
				left += ceil - floor - 1;
				int spaces = left / (ceil - floor - 1);
				int oneSpaceCnt = left % (ceil - floor - 1);
				String res = words[floor++];
				while (floor < ceil) {
					for (int i = 0; i < spaces; i++)
						res += " ";
					if (oneSpaceCnt != 0) {
						res += " ";
						oneSpaceCnt--;
					}
					res += words[floor++];
				}
				result.add(res);
			}
		}
		return result;
	}
}
