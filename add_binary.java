public class Solution {
	public String addBinary(String a, String b) {
		String result = "";
		int a_pos, b_pos, carry;
		for (a_pos = a.length() - 1, b_pos = b.length() - 1, carry = 0; a_pos >=0 && b_pos >= 0; a_pos--, b_pos--) {
			int sum = a.charAt(a_pos) - '0' + b.charAt(b_pos) - '0' + carry;
			carry = sum / 2;
			sum %= 2;
			result = sum + result;
		}
		while (a_pos >= 0) {
			int sum = a.charAt(a_pos) - '0' + carry;
			carry = sum / 2;
			sum %= 2;
			result = sum + result;
			a_pos--;
		}
		while (b_pos >= 0) {
			int sum = b.charAt(b_pos) - '0' + carry;
			carry = sum / 2;
			sum %= 2;
			result = sum + result;
			b_pos--;
		}
		if (carry != 0)
			result = carry + result;
		return result;
	}
}
