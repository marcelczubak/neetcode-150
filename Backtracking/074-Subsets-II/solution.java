import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(result, nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> subset) {
        
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Include this number
        subset.add(nums[index]);
        backtrack(result, nums, index+1, subset);

        // SKIP duplicates
        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        // SKIP current number
        backtrack(result, nums, index + 1, subset);

    }
}
