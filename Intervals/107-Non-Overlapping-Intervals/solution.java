import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int intervalsToRemove = 0;
        
        // Sort intervals based on start value
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // Save previous interval's end value at every iteration
        int prevEnd = intervals[0][1];

        // Iterate all intervals
        for (int i = 1; i < intervals.length; i++) {
            
            int[] interval = intervals[i];

            // Overlap
            if (interval[0] < prevEnd) {
                intervalsToRemove++;
                prevEnd = Math.min(prevEnd, interval[1]);
            } else {
                prevEnd = interval[1];
            }
        }
        return intervalsToRemove;
    }
}
