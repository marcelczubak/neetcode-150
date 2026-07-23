import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] answer = new int[queries.length];
        
        // Sort intervals by start value
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // Sort queries by value
        // Store original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; // query value
            sortedQueries[i][1] = i;          // original index
        }

        Arrays.sort(sortedQueries, (a,b) -> Integer.compare(a[0], b[0]));

        // Maintain a min-heap of intervals that are currently candidates (based on smallest interval length)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        // Idea : for each query, find the smallest interval such that start <= q <= end
        int intervalIndex = 0;

        // For each query
        for (int i = 0; i < sortedQueries.length; i++) {

            int query = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            // Add all intervals that start before or at query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                heap.add(intervals[intervalIndex]);
                intervalIndex++;
            }

            // Remove intervals that no longer include query
            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }

            if (!heap.isEmpty()) {
                int[] interval = heap.peek();
                // Length of interval
                answer[originalIndex] = (interval[1] - interval[0] + 1);
            } else {
                answer[originalIndex] = -1;
            }
        }   
        return answer;
    }
}