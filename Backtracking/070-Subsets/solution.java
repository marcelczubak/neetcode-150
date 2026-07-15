import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {

        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Include the number at index
        subset.add(nums[index]);
        dfs(nums, index+1, result, subset);


        // Don't include the number at index
        subset.remove(subset.size()-1);
        dfs(nums, index+1, result, subset);

    }
}