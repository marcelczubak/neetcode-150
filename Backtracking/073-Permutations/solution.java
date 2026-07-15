import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] used) {

        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        // Try every possible next number
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            // choose this
            used[i] = true;
            permutation.add(nums[i]);

            backtrack(result, permutation, nums, used);

            // undo choice
            used[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    } 
}
