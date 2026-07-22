import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultList = new ArrayList<>();

        int numIntervals = intervals.length;
        boolean inserted = false;

        // Iterate all intervals
        for (int i = 0; i < numIntervals; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Current interval before new interval
            if (currentEnd < newInterval[0]) {
                resultList.add(intervals[i]);

            // Current interval after new interval
            } else if (currentStart > newInterval[1]) {

                resultList.add(newInterval);
                inserted = true;

                for (int j = i; j < numIntervals; j++) {
                    resultList.add(intervals[j]);
                }
                break;

            } else {
                // Merge overlap
                newInterval[0] = Math.min(newInterval[0], currentStart);
                newInterval[1] = Math.max(newInterval[1], currentEnd);
            }
        }

        // New interval belongs at the end
        if (!inserted) {
            resultList.add(newInterval);
        }

        int[][] resultArray = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}