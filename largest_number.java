public class Solution {
	class Number implements Comparable<Number> {
		public String number;
		public Number(int number) { this.number = Integer.toString(number); }
		public int compareTo(Number num) {
			return compare(this.number, num.number);
		}
		private int compare(String num1, String num2) {
			if (num1.length() == num2.length())
				return num1.compareTo(num2);
			else if (num1.length() > num2.length()) {
				int flag = num1.substring(0, num2.length()).compareTo(num2);
				if (flag == 0)
					return compare(num1.substring(num2.length()), num2);
				else
					return flag;
			}
			else {
				int flag = num1.compareTo(num2.substring(0, num1.length()));
				if (flag == 0)
					return compare(num1, num2.substring(num1.length()));
				else
					return flag;
			}
		}
		public String toString() {
			return number;
		}
	}
	public String largestNumber(int[] num) {
		Number[] nums = new Number[num.length];
		for (int i = 0; i < num.length; i++) {
			nums[i] = new Number(num[i]);
		}
		Arrays.sort(nums);
		String res = "";
		for (Number n : nums)
			res = n + res;
		int i;
		for (i = 0; i < res.length() - 1 && res.charAt(i) == '0'; i++);
		return res.substring(i);
	}
}
public class largest_number {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println(sol.largestNumber(new int[]{128, 12}));
		System.out.println(sol.largestNumber(new int[]{0, 0}));
		System.out.println(sol.largestNumber(new int[]{8308, 830}));
	}
}
