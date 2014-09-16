public class Solution {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 0, j = 0; i < prices.length; i = j) {
			for (j = i + 1; j < prices.length && prices[j] >= prices[j - 1]; j++);
			maxprofit += prices[j - 1] - prices[i];
		}
		return maxprofit;
	}
}
