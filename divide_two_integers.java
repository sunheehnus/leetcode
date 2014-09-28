public class Solution {
	long abs(long a) {
		return a > 0 ? a : -a;
	}
	long[] div(long dividend, long divisor) {
		long[] result;
		if (dividend < divisor) {
			result = new long[2];
			result[1] = dividend;
		}
		else {
			result = div(dividend >>> 1, divisor);
			result[0] <<= 1;
			result[1] <<= 1;
			if ((dividend & 1) == 1)
				result[1]++;
			if (result[1] >= divisor) {
				result[1] -= divisor;
				result[0]++;
			}
		}
		return result;
	}
	public int divide(int dividend, int divisor) {
		int flag = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) ? -1 : 1;
		long[] result = div(abs(dividend), abs(divisor));
		return (int)(flag * result[0]);
	}
}
