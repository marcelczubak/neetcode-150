import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        // To avoid duplicates, sort list
        Arrays.sort(candidates);

        backtrack(result, candidates, target, 0, 0, new ArrayList<>());

        return result;

    }

    private void backtrack(List<List<Integer>> result, int[] candidates, int target, int index, int currentSum, List<Integer> currentNums) {

        if (currentSum == target) {
            result.add(new ArrayList<>(currentNums));
            return;
        }

        if (currentSum > target || index >= candidates.length) return;

        // Try all possible combinations from this index
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i-1] == candidates[i]) continue;

            currentNums.add(candidates[i]);

            // Next item attempted here
            backtrack(result, candidates, target, i+1, currentSum + candidates[i], currentNums);

            // Item removed if didnt work
            currentNums.remove(currentNums.size()-1);
        }
    }


}
