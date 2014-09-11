public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int [] delta = new int [gas.length << 1];
		for (int i = 0; i < gas.length; i++)
			delta [i + gas.length] = delta[i] = gas[i] - cost[i];
		for (int length = 0, i = 0, gas_left = 0; i < gas.length << 1; i++) {
			gas_left += delta[i];
			length++;
			while (gas_left < 0)
			{
				length--;
				gas_left -= delta[i - length];
			}
			if (length == gas.length)
				return (i - length + 1) % gas.length;
		}
		return -1;
	}
}
