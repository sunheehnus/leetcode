public class Solution {
	public int maxProfit_one_transaction(int[] prices, int start, int end) {
		int minimum = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = start; i <= end; i++) {
			if (prices[i] < minimum)
				minimum = prices[i];
			if (prices[i] - minimum > maxprofit)
				maxprofit = prices[i] - minimum;
		}
		return maxprofit;
	}
	public int maxProfit(int[] prices) {
		int minimum = Integer.MAX_VALUE;
		int maxprofit = maxProfit_one_transaction(prices, 0, prices.length - 1);
		for (int i = 0, j = 0; i < prices.length; i = j) {
			for (j = i + 1; j < prices.length && prices[j] <= prices[j - 1]; j++);
			for (; j < prices.length && prices[j] >= prices[j - 1]; j++);
			if (j == prices.length)
				break;
			int profit1 = maxProfit_one_transaction(prices, 0, j - 1);
			int profit2 = maxProfit_one_transaction(prices, j, prices.length - 1);
			if (profit1 + profit2 > maxprofit)
				maxprofit = profit1 + profit2;
		}
		return maxprofit;
	}
}
