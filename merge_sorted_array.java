public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int cur = m + n - 1;
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1])
				A[cur--] = A[--m];
			else
				A[cur--] = B[--n];
		}
		while (m > 0)
			A[cur--] = A[--m];
		while (n > 0)
			A[cur--] = B[--n];
	}
}
