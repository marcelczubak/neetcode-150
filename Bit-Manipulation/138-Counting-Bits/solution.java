class Solution {
    public int[] countBits(int n) {


        // n = 16
        // 0             0       
        // 1             1       offset = 1
 
        // 10            1       offset = 2
        // 11            2

        // 100           1       offset = 4
        // 101           2
        // 110           2 
        // 111           3

        // 1000          1       offset = 8
        // 1001          2
        // 1010          2
        // 1011          3
        // 1100          2
        // 1101          3
        // 1110          3           
        // 1111          4


        int[] dp = new int[n+1];
        dp[0] = 0;

        int offset = 1;

        for (int i = 1; i < dp.length; i++) {
            if (i == offset*2) offset *= 2;
            dp[i] = 1 + dp[i-offset];
        }

        return dp;
    }
}
