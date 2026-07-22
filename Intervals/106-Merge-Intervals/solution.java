import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort all intervals based on starting order
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        // Add first interval
        result.add(intervals[0]);

        // For all remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Get the last appended interval in result
            int[] latest = result.get(result.size() - 1);

            // Overlap ... modify end value and proceed
            if (currentStart <= latest[1]) {
                latest[1] = Math.max(latest[1], currentEnd);
                result.set(result.size() - 1, latest);
            } else {
                // Add the interval if no overlap occurred
                result.add(intervals[i]);
            }
        }

        // Process the output
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
