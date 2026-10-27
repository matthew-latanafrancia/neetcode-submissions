class Solution {
    public int maxProfit(int[] prices) {
        // edge case (0 days and 1 day i think)
        if (prices.length == 1) {
            return 0;
        }

        // The real case with 2 pointers
        int buyPointer = 0;
        int sellPointer = buyPointer + 1;
        int maxProfit = 0;

        while (sellPointer < prices.length) {
            // Before checking buy, check current profit on the two days
            if (prices[sellPointer] - prices[buyPointer] > maxProfit) {
                maxProfit = prices[sellPointer] - prices[buyPointer];
            }
            if (prices[buyPointer] > prices[sellPointer]) {
                // Switch buy pointer to this because if max profit will be more to the right, this would have to be the next buy
                buyPointer = sellPointer;
            }
            sellPointer++;
        }

        return maxProfit;
    }
}
