import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {

        // Memoisation map
        Map<String, Boolean> memo = new HashMap<>();
        
        // Accumulate sum
        int sum = 0;
        for (int num : nums) sum += num;

        // If sum not even, partition not possible
        if (sum % 2 != 0) return false;

        // Return recursion
        return partition(memo, nums, 0, 0, sum/2);
    }

    // Try to form a subset which adds up to target
    private boolean partition(Map<String, Boolean> memo, int[] nums, int i, int curSum, int target) {
        
        if (curSum == target) return true;
        if (i >= nums.length || curSum > target) return false;

        // Encode key and check if already precomputed
        String key = String.valueOf(i) + "." + String.valueOf(curSum);
        if (memo.containsKey(key)) return memo.get(key);

        // Either include this element or skip
        boolean takeCurrent = partition(memo, nums, i+1, curSum + nums[i], target);
        boolean skipCurrent = partition(memo, nums, i+1, curSum, target);

        memo.put(key, takeCurrent || skipCurrent);

        // Did any result return true?
        return takeCurrent || skipCurrent;
    }
}