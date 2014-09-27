public class Solution {
	void swap(int[] array, int pos1, int pos2) {
		int tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}
	public void nextPermutation(int[] num) {
		int pos1, pos2;
		for (pos1 = num.length - 1, pos2 = pos1; pos1 >= 0; pos1--) {
			for (pos2 = num.length - 1; pos2 > pos1 && num[pos2] <= num[pos1]; pos2--);
			if (pos2 > pos1)
				break;
		}
		if (pos1 < 0) {
			for (int i = 0, j = num.length - 1; i < j; i++, j--)
				swap(num, i, j);
		}
		else {
			swap(num, pos1, pos2);
			Arrays.sort(num, pos1 + 1, num.length);
		}
	}
}
