public class Solution {
	public int maxProduct(int[] A) {
		if (A.length == 1)
			return A[0];
		int max = Integer.MIN_VALUE;
		int length = 0;
		for (int i = 0, j = 0; i < A.length; i = j, length++) {
			int val = A[j++];
			if (val > 0) {
				for (; j < A.length && A[j] > 0; j ++)
					val *= A[j];
			}
			A[length] = val;
			if (val > max)
				max = val;
		}
		for (int i = 0, j = 0; i < length; i = j) {
			for (; i < length && A[i] == 0; i++);
			if (i >= length)
				break;
			int negCnt = 0;
			for (j = i; j < length && A[j] != 0; j++) {
				if (A[j] < 0)
					negCnt++;
			}
			if ((negCnt & 1)== 1) {
				int cnt = negCnt;
				int val = 1;
				int k = i;
				for (; k < j && !(cnt == 1 && A[k] < 0); k++) {
					val *= A[k];
					if (A[k] < 0)
						cnt--;
				}
				if (k != i && val > max)
					max = val;
				cnt = negCnt;
				val = 1;
				k = j - 1;
				for (; k >= i && !(cnt == 1 && A[k] < 0); k--) {
					val *= A[k];
					if (A[k] < 0)
						cnt--;
				}
				if (k != j - 1 && val > max)
					max = val;
			}
			else {
				int val = 1;
				for (int k = i; k < j; k++)
					val *= A[k];
				if (val > max)
					max = val;
			}
		}
		return max;
	}
}
