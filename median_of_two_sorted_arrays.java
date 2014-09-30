import java.util.*;
public class Solution {
	int binarySearchAbove(int array[], int start, int end, int element) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] >= element)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}
	int findKthElement(int A[], int B[], int k) {
		int startA, endA, startB, endB;
		startA = 0;
		endA = A.length - 1;
		startB = 0;
		endB = B.length - 1;
		while (true) {
			if (startA > endA)
				return B[startB + k - 1];
			if (startB > endB)
				return A[startA + k - 1];
			int posA = startA + (endA - startA) / 2;
			int posB = binarySearchAbove(B, startB, endB, A[posA]);
			if (posA - startA + 1 + posB - startB == k)
				return A[posA];
			else if (posA - startA + 1 + posB - startB > k) {
				endA = posA - 1;
				endB = posB - 1;
			}
			else {
				k -= posA - startA + 1 + posB - startB;
				startA = posA + 1;
				startB = posB;
			}
		}
	}
	public double findMedianSortedArrays(int A[], int B[]) {
		int length = A.length + B.length;
		if ((length & 1) == 1)
			return findKthElement(A, B, (length + 1) / 2);
		else
			return (findKthElement(A, B, length / 2) + findKthElement(A, B, length / 2 + 1)) / 2.0;
	}
}
