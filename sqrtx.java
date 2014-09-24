public class Solution {
	int abs(int a) {
		return a > 0 ? a : -a;
	}
	public int sqrt(int x) {
		int guess = 1203;
		while (abs(guess - x / guess) > 1) {
			int next = (guess + x / guess) / 2;
			guess = next;
		}
		return (guess + x / guess) / 2;
	}
}
