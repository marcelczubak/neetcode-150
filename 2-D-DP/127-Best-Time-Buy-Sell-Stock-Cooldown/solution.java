class Solution {
    public int maxProfit(int[] prices) {

        Integer[][] cache = new Integer[prices.length][2];

        return findProfit(cache, prices, 0, false);
    }

    private int findProfit(Integer[][] cache, int[] prices, int i, boolean coinOwned) {

        if (i >= prices.length) return 0;

        int owned = (coinOwned) ? 1 : 0;

        if (cache[i][owned] != null) return cache[i][owned];

        int maxProfit = 0;

        if (coinOwned) {

            //                         sell today, skip a day                       keep holding the coin
            maxProfit = Math.max(prices[i] + findProfit(cache, prices, i+2, !coinOwned), findProfit(cache, prices, i+1, coinOwned));
        } else {
            //                         buy today, can sell the next day              still have no coin
            maxProfit = Math.max(findProfit(cache, prices, i+1, !coinOwned) - prices[i], findProfit(cache, prices, i+1, coinOwned));
        }

        cache[i][owned] = maxProfit;

        return maxProfit;
    }

}
