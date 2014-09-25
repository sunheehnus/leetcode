import java.math.BigInteger;
public class Solution {
	boolean judge(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	BigInteger[] findFirst26Primes() {
		BigInteger[] primes = new BigInteger[26];
		int cnt = 0;
		for (int i = 2; cnt < 26; i++) {
			if (judge(i))
				primes[cnt++] = new BigInteger("" + i);
		}
		return primes;
	}
	public List<String> anagrams(String[] strs) {
		List<String> result = new LinkedList<String>();
		if (strs.length == 0)
			return result;
		BigInteger[] primes = findFirst26Primes();
		BigInteger[] nums = new BigInteger[strs.length];
		int pos = 0;
		for (String str : strs) {
			BigInteger big = new BigInteger("1");
			for (int i = 0; i < str.length(); i++)
				big = big.multiply(primes[str.charAt(i) - 'a']);
			nums[pos++] = big;
		}
		Arrays.sort(nums);
		int cnt = 0;
		for (int i = 0, j = 0; i < nums.length; i = j) {
			for (j = i + 1; j < nums.length && nums[i].equals(nums[j]); j++);
			if (j - i > 1)
				nums[cnt++] = nums[i];
		}
		for (String str : strs) {
			BigInteger big = new BigInteger("1");
			for (int i = 0; i < str.length(); i++)
				big = big.multiply(primes[str.charAt(i) - 'a']);
			if (Arrays.binarySearch(nums, 0, cnt, big) >= 0)
				result.add(str);
		}
		return result;
	}
}
