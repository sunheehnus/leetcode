public class Solution {
	public int reverse(int x) {
		int result;
		if (x >= 0) {
			for (result = 0; x != 0; x /= 10) {
				result *= 10;
				result += x % 10;
			}
		}
		else {
			x = - x;
			for (result = 0; x != 0; x /= 10) {
				result *= 10;
				result -= x % 10;
			}
		}
		return result;
	}
}
