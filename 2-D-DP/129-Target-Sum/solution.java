import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        Map<String, Integer> cache = new HashMap<>();
        return computeSums(cache, nums, target, 0);
    }

    private int computeSums(Map<String, Integer> cache, int[] nums, int target, int currentIndex) {

        String key = String.valueOf(target) + "," + String.valueOf(currentIndex);
        if (cache.containsKey(key)) return cache.get(key);

        if (currentIndex == nums.length) return (target == 0) ? 1 : 0;

        int ways = computeSums(cache, nums, target+nums[currentIndex], currentIndex+1) + 
                computeSums(cache, nums, target-nums[currentIndex], currentIndex+1);

        cache.put(key, ways);
        return ways;
    }

}
