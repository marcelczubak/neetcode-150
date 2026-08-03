class Solution {
    public int missingNumber(int[] nums) {
        
        // XOR all numbers from 0 to n
        int a = nums.length;

        for (int i = 0; i < nums.length; i++) {
            a ^= i;
            a ^= nums[i];
        }

        return a;
    }
}
