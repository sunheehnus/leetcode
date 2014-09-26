public class Solution {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];

		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] >= target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		if (start >= A.length || A[start] != target) {
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		result[0] = start;
		start = 0;
		end = A.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		result[1] = end;
		return result;
	}
}
