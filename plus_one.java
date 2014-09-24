public class Solution {
	public int[] plusOne(int[] digits) {
		int i;
		for (i = 0; i < digits.length && digits[i] == 9; i++);
		int carry = i >= digits.length ? 1 : 0;

		int length = digits.length + carry;
		int[] result = new int[length];

		for (i = 0; i < digits.length; i++)
			result[i + carry] = digits[i];

		result[result.length - 1]++;
		for (i = result.length - 1; i >= 0 && result[i] > 9; i--) {
			result[i] = 0;
			result[i - 1]++;
		}
		return result;
	}
}
