public class Solution {
	double square(double d) {
		return d * d;
	}
	double powPositive(double x, int n) {
		if (n == 0)
			return 1;
		if ((n & 1) == 1)
			return x * powPositive(x, n - 1);
		else
			return square(powPositive(x, n/2));
	}
	public double pow(double x, int n) {
		if (n >= 0)
			return powPositive(x, n);
		else {
			if (n == Integer.MIN_VALUE) {
				return 1 / (powPositive(x, Integer.MAX_VALUE) * x);
			}
			return 1 / powPositive(x, -n);
		}
	}
}
