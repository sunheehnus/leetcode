import java.math.BigInteger;
public class Solution {
	public String multiply(String num1, String num2) {
		BigInteger bi1 = new BigInteger(num1);
		BigInteger bi2 = new BigInteger(num2);
		return bi1.multiply(bi2).toString();
	}
}
