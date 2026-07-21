import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int result = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);

            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}


//       RECURSION + MEMOIZATION APPROACH

// class Solution {
//     public int lengthOfLIS(int[] nums) {
        
//         int result = 0;

//         int[] memo = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             result = Math.max(result, dfs(memo, nums, i));
//         }

//         return result;
//     }

//     private int dfs(int[] memo, int[] nums, int index) {

//         if (memo[index] != 0) return memo[index];

//         // Take current element alone
//         int answer = 1;

//         for (int j = index + 1; j < nums.length; j++) {

//             if (nums[index] < nums[j]) {
//                 answer = Math.max(answer, 1 + dfs(memo, nums, j));
//             }


//         }
//         memo[index] = answer;
//         return answer;
//     }


// }
