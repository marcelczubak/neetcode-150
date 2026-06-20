class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] < nums[right]) {
                // Minimum in left segment
                right = mid;
            } else if(nums[left] < nums[mid]) {
                // Minimum in right segment
                left = mid;
            } else {
                return nums[right];
            }
        }
        return nums[0];
    }
}
