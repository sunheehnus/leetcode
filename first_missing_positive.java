public class Solution {
	void swap(int[] array, int pos1, int pos2) {
		int tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; i++) {
			while (A[i] >= 1 && A[i] <= A.length && A[i] != i + 1 && A[i] != A[A[i] - 1])
				swap(A, i, A[i] - 1);
		}
		int pos = 0;
		for (pos = 0; pos < A.length && A[pos] == pos + 1; pos++);
		return pos + 1;
	}
}
