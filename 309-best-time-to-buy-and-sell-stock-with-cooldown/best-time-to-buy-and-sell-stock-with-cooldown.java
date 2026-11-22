class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int ahead1Buy = 0;
        int ahead2Buy = 0;
        int ahead1Sell = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currBuy = Math.max(-prices[i] + ahead1Sell, ahead1Buy);
            int currSell = Math.max(prices[i] + ahead2Buy, ahead1Sell);

            ahead2Buy = ahead1Buy;
            ahead1Buy = currBuy;
            ahead1Sell = currSell;
        }

        return ahead1Buy;
    }
}