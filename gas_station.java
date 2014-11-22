public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int pos = 0;
        int preCost = 0;
        int gasLeft = 0;
		for (int i = 0; i < gas.length; i++) {
			gasLeft += gas[i] - cost[i];
            if (gasLeft < 0)
            {
                pos = i + 1;
                preCost += gasLeft;
                gasLeft = 0;
            }
		}
        if (pos != gas.length && gasLeft + preCost >= 0)
            return pos;
		return -1;
	}
}
