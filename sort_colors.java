public class Solution {
	public void sortColors(int[] A) {
		int floor, ceil, cur;
		for (floor = 0; floor < A.length && A[floor] == 0; floor++);
		for (ceil = A.length - 1; ceil >= floor && A[ceil] == 2; ceil--);
		if (floor > ceil)
			return;
		cur = floor;
		while (cur <= ceil) {
			while (cur <= ceil && A[cur] == 1)
				cur++;
			if (cur > ceil)
				return;
			if (A[cur] == 0) {
				int tmp = A[floor];
				A[floor] = A[cur];
				A[cur] = tmp;
				for (; floor < A.length && A[floor] == 0; floor++);
			}
			else {
				int tmp = A[ceil];
				A[ceil] = A[cur];
				A[cur] = tmp;
				for (; ceil >= floor && A[ceil] == 2; ceil--);
			}
			if (cur < floor)
				cur = floor;
		}
	}
}
