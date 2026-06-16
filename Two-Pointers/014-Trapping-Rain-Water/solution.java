class Solution {
    public int trap(int[] height) {

        int water = 0;
        int N = height.length;
        
        int[] prefix = height.clone();
        int[] suffix = height.clone();

        for (int i = 1; i < N; i++) {
            if (prefix[i] < prefix[i-1]) prefix[i] = prefix[i-1];
        }

        for (int i = N - 2; i >= 0; i--) {
            if (suffix[i] < suffix[i+1]) suffix[i] = suffix[i+1];
        }

        for (int i = 0; i < N; i++) {

            int thisWater = Math.min(prefix[i],suffix[i]) - height[i];

            if (thisWater > 0) water += thisWater;
        }

        return water;
    }
}
