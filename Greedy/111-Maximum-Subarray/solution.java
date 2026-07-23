class Solution {
    public int maxSubArray(int[] nums) {
        
        int curSum = nums[0];
        int maxSum = curSum;

        for (int i = 1; i < nums.length; i++) {
            
            // Either extend curSum with this element, or, start fresh
            curSum = Math.max(curSum + nums[i], nums[i]);
            // Update maximum at every step 
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
