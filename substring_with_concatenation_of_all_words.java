public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new LinkedList<Integer>();

		if (L.length == 0 || S.length() < L.length * L[0].length())
			return result;

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : L) {
			if (map.containsKey(str))
				map.put(str, map.get(str) + 1);
			else
				map.put(str, 1);
		}

		int length = L[0].length();
		for (int i = 0; i <= S.length() - length; i++) {
			String str = S.substring(i, i + length);
			if (map.containsKey(str)) {
				int j = i;
				int cnt = L.length;
				Map<String, Integer> judgeMap = new HashMap<String, Integer>(map);
				while (cnt > 0 && judgeMap.containsKey(str)) {
					cnt--;
					int left = judgeMap.get(str);
					if (left == 1)
						judgeMap.remove(str);
					else
						judgeMap.put(str, left - 1);
					j += length;
					if (j + length > S.length())
						break;
					str = S.substring(j, j + length);
				}
				if (cnt == 0)
					result.add(i);
			}
		}
		return result;
	}
}
