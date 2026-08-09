class Solution {
    public int maxCoins(int[] nums) {

        int[] paddedNums = new int[nums.length+2];
        paddedNums[0] = 1;
        paddedNums[nums.length+1] = 1;

        for (int i = 1; i < paddedNums.length-1; i++) paddedNums[i] = nums[i-1];

        Integer[][] cache = new Integer[nums.length+2][nums.length+2];

        return popBalloons(cache, paddedNums, 1, nums.length);
    }

    private int popBalloons(Integer[][] cache, int[] nums, int left, int right) {

        if (cache[left][right] != null) return cache[left][right];

        int coins = 0;

        for (int i = left; i <= right; i++) {
            
            int thisPop = nums[i] * nums[left-1] * nums[right+1];

            int theseCoins = popBalloons(cache, nums, left, i-1) + thisPop + popBalloons(cache, nums, i+1, right);

            coins = Math.max(coins, theseCoins);
        }

        cache[left][right] = coins;
        return coins;
    }
}