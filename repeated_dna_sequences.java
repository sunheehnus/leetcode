public class Solution {
	long buildNum(long res, char c) {
		res %= 1000000000;
		res *= 10;
		switch (c) {
			case 'A':
				res += 0;
				break;
			case 'C':
				res += 1;
				break;
			case 'G':
				res += 2;
				break;
			case 'T':
				res += 3;
				break;
			default:
				break;
		}
		return res;
	}
	String buildString(long res) {
		String result = "";
		for (int i = 0; i < 10; i++) {
			switch ((int)(res % 10)) {
				case 0:
					result = "A" + result;
					break;
				case 1:
					result = "C" + result;
					break;
				case 2:
					result = "G" + result;
					break;
				case 3:
					result = "T" + result;
					break;
				default:
					break;
			}
			res /= 10;
		}
		return result;
	}
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new LinkedList<String>();
		if (s.length() <= 10)
			return result;
		long[] numDnas = new long[s.length() - 9];
		long res = 0;
		for (int i = 0; i < 9; i++) {
			res = buildNum(res, s.charAt(i));
		}
		for (int i = 9; i < s.length(); i++) {
			res = buildNum(res, s.charAt(i));
			numDnas[i - 9] = res;
		}
		Arrays.sort(numDnas);
		for (int i = 0, j = 0; i < numDnas.length; i = j) {
			for (j = i + 1; j < numDnas.length && numDnas[j] == numDnas[i]; j++);
			if (j - i > 1) {
				result.add(buildString(numDnas[i]));
			}
		}
		return result;
	}
}
