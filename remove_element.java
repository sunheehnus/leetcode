public class Solution {
	public int removeElement(int[] A, int elem) {
		int length, pos;
		for (length = 0, pos = 0; pos < A.length;) {
			while (pos < A.length && A[pos] == elem)
				pos++;
			if (pos >= A.length)
				break;
			A[length++] = A[pos++];
		}
		return length;
	}
}
