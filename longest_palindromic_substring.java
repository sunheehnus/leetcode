public class Solution {
	boolean cmp(int[] rank, int pos1, int pos2, int l) {
		return rank[pos1] == rank[pos2] && rank[pos1 + l] == rank[pos2 + l];
	}
	int[] buildSuffixArray(char[] cArray) {
		int length = cArray.length;
		int cntSortCeil = Character.MAX_VALUE;
		int[] suffixArray = new int[length];
		int[] rank = new int[length];
		int[] cntSort = new int[length > (Character.MAX_VALUE + 1) ? length : (Character.MAX_VALUE + 1)];
		int[] y = new int[length];
		int[] shiftLSuffixArray = new int[length];
		int i, l, kinds;
		for (i = 0; i < cntSortCeil; i++)
			cntSort[i] = 0;
		for (i = 0; i < length; i++)
			cntSort[rank[i] = cArray[i]] ++;
		for (i = 1; i < cntSortCeil; i++)
			cntSort[i] += cntSort[i - 1];
		for (i = length - 1; i >= 0; i--)
			suffixArray[--cntSort[cArray[i]]] = i;
		for (l = 1, kinds = 1; kinds < length; l *= 2, cntSortCeil = kinds) {
			for (kinds = 0, i = length - l; i < length; i ++)
				y[kinds++] = i;
			for (i = 0; i < length; i++) {
				if (suffixArray[i] >= l)
					y[kinds++] = suffixArray[i] - l;
			}
			for (i = 0; i < length; i++)
				shiftLSuffixArray[i] = rank[y[i]];
			for (i = 0; i < cntSortCeil; i++)
				cntSort[i] = 0;
			for (i = 0; i < length; i++)
				cntSort[shiftLSuffixArray[i]]++;
			for (i = 1; i < cntSortCeil; i++)
				cntSort[i] += cntSort[i - 1];
			for (i = length - 1; i >= 0; i--)
				suffixArray[--cntSort[shiftLSuffixArray[i]]] = y[i];
			int[] tmp = y;
			y = rank;
			rank = tmp;
			for (kinds = 1, rank[suffixArray[0]] = 0, i = 1; i < length; i++) {

				if (cmp(y, suffixArray[i - 1], suffixArray[i], l))
					rank[suffixArray[i]] = kinds - 1;
				else
					rank[suffixArray[i]] = kinds++;
			}
		}
		return suffixArray;
	}
	int[] calheight(char[] cArray, int[] suffixArray) {
		int length = suffixArray.length;
		int[] rank = new int[length];
		int[] height = new int[length];
		for (int i = 0; i < length; i++)
			rank[suffixArray[i]] = i;
		height[0] = 0;
		for (int i = 0, k = 0; i < length; i++) {
			k = (0 >= k - 1) ? 0 : (k - 1);
			if (rank[i] == 0)
				continue;
			for (int j = suffixArray[rank[i] - 1]; cArray[i + k] == cArray[j + k]; k++);
			height[rank[i]] = k;
		}
		return height;
	}
	String reverse(String s) {
		char[] reversedSArray = s.toCharArray();
		for (int i = 0, j = reversedSArray.length - 1; i < j; i++, j--) {
			reversedSArray[i] ^= reversedSArray[j];
			reversedSArray[j] ^= reversedSArray[i];
			reversedSArray[i] ^= reversedSArray[j];
		}
		return new String(reversedSArray);
	}
	class PosValue implements Comparable<PosValue> {
		int pos, value;
		public PosValue(int pos, int value) {
			this.pos = pos;
			this.value = value;
		}
		public int compareTo(PosValue pv) {
			if (this.value > pv.value)
				return 1;
			if (this.value < pv.value)
				return -1;
			return 0;
		}
	}
	public String longestPalindrome(String s) {
		String str255rts0 = s + '\255' + reverse(s) + '\0';
		char[] cArray = str255rts0.toCharArray();
		int[] suffixArray = buildSuffixArray(cArray);
		int[] height = calheight(cArray, suffixArray);
		PosValue[] heightWithPos = new PosValue[height.length];
		for (int i = 0; i < height.length; i++)
			heightWithPos[i] = new PosValue(i, height[i]);
		Arrays.sort(heightWithPos);
		for (int i = height.length - 1; i >= 0; i--) {
			int pos = heightWithPos[i].pos;
			int val = heightWithPos[i].value;
			if (suffixArray[pos] > s.length() && suffixArray[pos - 1] < s.length())
				return s.substring(suffixArray[pos - 1], suffixArray[pos - 1] + val);
			else if (suffixArray[pos] < s.length() && suffixArray[pos - 1] > s.length())
				return s.substring(suffixArray[pos], suffixArray[pos] + val);
		}
		return "";
	}
}
