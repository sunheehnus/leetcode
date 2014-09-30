import java.util.*;
public class Solution {
	class NumPos implements Comparable<NumPos> {
		int val, pos;
		public NumPos(int val, int pos) {
			this.val = val;
			this.pos = pos;
		}
		public int compareTo(NumPos np) {
			if (this.val > np.val)
				return 1;
			else if (this.val < np.val)
				return -1;
			return 0;
		}
	}
	public int[] twoSum(int[] numbers, int target) {
		NumPos[] numPos = new NumPos[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			numPos[i] = new NumPos(numbers[i], i + 1);
		Arrays.sort(numPos);

		int[] result = new int[2];
		for (int i = 0, j = numPos.length - 1; i < j;) {
			if (numPos[i].val + numPos[j].val < target)
				i++;
			else if (numPos[i].val + numPos[j].val > target)
				j--;
			else {
				result[0] = numPos[i].pos > numPos[j].pos ? numPos[j].pos : numPos[i].pos;
				result[1] = numPos[i].pos > numPos[j].pos ? numPos[i].pos : numPos[j].pos;
				break;
			}
		}
		return result;
	}
}
