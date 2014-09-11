public class Solution {
	public int singleNumber(int[] A) {
		int [] array = new int [32];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 32; j++) {
				array[j] += (A[i] >> j) & 1;
			}
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result |= (array[i] %= 3) << i;
		}
		return result;
	}
}
