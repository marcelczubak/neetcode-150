class Solution {
    public int numDecodings(String s) {

        int prev2 = 1; 
        int prev1 = (s.charAt(0) != '0') ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {

            int current = 0;

            // Is s[i-1] valid alone?
            int num = s.charAt(i-1) - '0';
            if (num >= 1 && num <= 9) {
                current += prev1;
            }

            // Is s[i-2 : i] between 10 and 26?
            num = Integer.parseInt(s.substring(i-2, i));
            if (num >= 10 && num <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;

        }
        return prev1;
    }
}

// class Solution {
//     public int numDecodings(String s) {
//
//         // dp[i] = number of ways to decode the first i characters
//         int[] dp = new int[s.length() + 1];

//         // An empty string can be decoded in one way
//         dp[0] = 1; 
//         dp[1] = (s.charAt(0) - '0' != 0) ? 1 : 0;

//         for (int i = 2; i <= s.length(); i++) {

//             // Is s[i-1] valid alone?
//             int num = s.charAt(i-1) - '0';
//             if (num >= 1 && num <= 9) dp[i] += dp[i-1];


//             // Is s[i-2 : i] between 10 and 26?
//             num = Integer.parseInt(s.substring(i-2, i));
//             if (num >= 10 && num <= 26) dp[i] += dp[i-2];
//         }

//         return dp[s.length()];

//     }
// }