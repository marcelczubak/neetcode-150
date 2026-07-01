class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);

            // get the value at index num
            int index = num - 1;

            if (nums[index] < 0) {
                // duplicate found
                return num;
            } else {
                // mark as seen
                nums[index] *= -1; 
            }
        }
        // no duplicate exists
        return -1;
    }
}
