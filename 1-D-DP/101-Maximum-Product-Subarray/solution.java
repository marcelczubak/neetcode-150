class Solution {
    public int maxProduct(int[] nums) {
        
        int result = nums[0], currentMax = nums[0], currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax *= nums[i];
            currentMin *= nums[i];

            int temp = Math.max(nums[i], Math.max(currentMax, currentMin));
            currentMin = Math.min(nums[i], Math.min(currentMax, currentMin));
            currentMax = temp;

            result = Math.max(Math.max(currentMax, currentMin), result);
        }
        return result;
    }
}
