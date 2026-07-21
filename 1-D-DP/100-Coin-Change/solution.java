import java.util.*;

class Solution {

    public int coinChange(int[] coins, int amount) {
        
        // Memoization Cache
        Map<Integer, Integer> memo = new HashMap<>();
        
        // DFS call
        int result = numberOfCoins(memo, coins, amount);

        return (result != Integer.MAX_VALUE) ? result : -1;

    }

    private int numberOfCoins(Map<Integer, Integer> memo, int[] coins, int amount) {

        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;

        // If precomputed, simply return
        if (memo.containsKey(amount)) return memo.get(amount);

        // Default
        int answer = Integer.MAX_VALUE;

        // Compute all branches at all branches
        for (int coin : coins) {
            int res = numberOfCoins(memo, coins, amount - coin);
            if (res != Integer.MAX_VALUE) answer = Math.min(answer, 1 + res);
        }

        // Store in cache
        memo.put(amount, answer);
        return answer;
    }
}
