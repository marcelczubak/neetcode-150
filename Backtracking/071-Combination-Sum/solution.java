import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, target, 0, 0);

        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentNums, int[] nums, int target, int index, int currentSum) {
        
        if (currentSum == target) {
            result.add(new ArrayList<>(currentNums));
            return;
        }
        
        if (index >= nums.length || currentSum > target) return;

        // take current number again
        currentNums.add(nums[index]);
        backtrack(result, currentNums, nums, target, index, currentSum + nums[index]);
        
        // move to next number instead
        currentNums.remove(currentNums.size()-1);
        backtrack(result, currentNums, nums, target, index+1, currentSum);
    }
}
