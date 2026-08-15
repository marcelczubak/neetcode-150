import java.util.*;
 
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // At most k stops == At most k+1 flights


        // Cheapest cost currently known to reach this airport using the num of flights processed so far
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == src) dp[i] = 0;
            else dp[i] = Integer.MAX_VALUE;
        }

        // Process flights layer by layer
        for (int layer = 0; layer < k+1; layer++) {
            
            // "Next" layer to avoid processing same flights in layer
            int[] next = Arrays.copyOf(dp, n);

            // Look at all flights
            for (int i = 0; i < flights.length; i++) {
                
                int[] flight = flights[i];

                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                if (dp[u] != Integer.MAX_VALUE) {
                    // Destination v potentially reachable

                    int newCost = dp[u] + price;
                    next[v] = Math.min(next[v], newCost);
                }
            }

            dp = next;
        }

        return (dp[dst] != Integer.MAX_VALUE) ? dp[dst] : -1;
    }
}
