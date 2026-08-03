class Solution {
    public int change(int amount, int[] coins) {

        Integer[][] cache = new Integer[coins.length][amount+1];

        return tryCombinations(cache, 0, amount, coins);
    }

    private int tryCombinations(Integer[][] cache, int currentIndex, int amount, int[] coins) {
        
        if (amount < 0 || currentIndex == coins.length) return 0;
        if (cache[currentIndex][amount] != null) return cache[currentIndex][amount];

        if (amount == 0) return 1;

        int ways = 0;

        for (int i = currentIndex; i < coins.length; i++) {
            ways += tryCombinations(cache, i, amount - coins[i], coins);
        }

        cache[currentIndex][amount] = ways;

        return ways;
    }
}
