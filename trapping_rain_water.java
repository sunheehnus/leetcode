public class Solution {
	public int trap(int[] A) {
		int maxValuePos = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[maxValuePos])
				maxValuePos = i;
		}
		int water = 0;
		int preMax = 0;
		for (int i = 0; i < maxValuePos; i++) {
			if (A[i] > preMax)
				preMax = A[i];
			else
				water += preMax - A[i];
		}
		int sufMax = 0;
		for (int i = A.length - 1; i > maxValuePos; i--) {
			if (A[i] > sufMax)
				sufMax = A[i];
			else
				water += sufMax - A[i];
		}
		return water;
	}
}
