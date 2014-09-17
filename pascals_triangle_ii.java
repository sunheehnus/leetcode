import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
public class Solution {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == -1) {
			return new LinkedList<Integer>();
		}
		Integer [] pre_row = new Integer[rowIndex + 1];
		Integer [] cur_row = new Integer[rowIndex + 1];
		cur_row[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			Integer [] dummy_exchange = cur_row;
			cur_row = pre_row;
			pre_row = dummy_exchange;
			cur_row[0] = cur_row[i] = 1;
			for (int j = 1; j < i; j++) {
				cur_row[j] = pre_row[j] + pre_row[j - 1];
			}
		}
		List<Integer> result = new LinkedList<Integer>();
		return Arrays.asList(cur_row);
	}
	public static void main(String [] args) {
		Solution sol = new Solution();
		System.out.println(sol.getRow(1));
		System.out.println(sol.getRow(2));
		System.out.println(sol.getRow(3));
		System.out.println(sol.getRow(4));
		System.out.println(sol.getRow(5));
	}
}
