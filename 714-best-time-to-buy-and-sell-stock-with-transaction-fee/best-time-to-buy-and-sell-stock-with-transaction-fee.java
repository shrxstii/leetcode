class Solution {
    public int maxProfit(int[] prices, int fee) {
        int aheadBuy = 0;
        int aheadSell = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int currBuy = Math.max(-prices[i] + aheadSell, aheadBuy);
            int currSell = Math.max(prices[i] - fee + aheadBuy, aheadSell);

            aheadBuy = currBuy;
            aheadSell = currSell;
        }

        return aheadBuy;
    }
}