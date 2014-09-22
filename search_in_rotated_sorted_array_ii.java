public class Solution {
	public boolean search(int[] A, int target) {
		if (A.length == 0)
			return false;
		int start = 0, end = A.length - 1;
		while (start <= end && A[start] < A[0]) {
			int mid = start + (end - start) / 2;
			if (A[mid] >= A[start])
				start = mid + 1;
			else if (A[mid] < A[start])
				end = mid - 1;
		}
		if (start >= A.length) {
			int start1 = 0, end1 = start - 1, start2 = start, end2 = A.length - 1;
			while (start1 <= end1) {
				int mid = start1 + (end1 - start1) / 2;
				if (A[mid] < target)
					start1 = mid + 1;
				else if (A[mid] > target)
					end1 = mid - 1;
				else
					return true;
			}
			while (start2 <= end2) {
				int mid = start2 + (end2 - start2) / 2;
				if (A[mid] < target)
					start2 = mid + 1;
				else if (A[mid] > target)
					end2 = mid - 1;
				else
					return true;
			}
		}
		else {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == target)
					return true;
			}
		}
		return false;
	}
}
