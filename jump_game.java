public class Solution {
	public boolean canJump(int[] A) {
		int ceil, floor;
		ceil = A.length - 1;
		while (ceil > 0){
			for (floor = ceil - 1; floor >= 0 && A[floor] < ceil - floor; floor--);
			ceil = floor;
		}
		return ceil == 0;
	}
}
