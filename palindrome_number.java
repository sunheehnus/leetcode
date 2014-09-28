public class Solution {
	int getLength(int x) {
		int length = 0;
		while (x != 0) {
			length++;
			x /= 10;
		}
		return length;
	}
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int length = getLength(x);
		int floor = 1, ceil;
		for (ceil = 1; length > 1; ceil *= 10, length--);
		for (; floor < ceil; floor *= 10, ceil /= 10) {
			if (x / floor % 10 != x / ceil % 10)
				return false;
		}
		return true;
	}
}
