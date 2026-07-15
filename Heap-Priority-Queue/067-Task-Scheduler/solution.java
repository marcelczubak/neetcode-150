import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Total time
        int totalTime = 0;
        
        // Populate frequencies array
        int[] frequencies = new int[26];
        for (char task : tasks) frequencies[task - 'A']++;
        
        // Initialise max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Populate max heap with frequencies
        for (int freq : frequencies) if (freq != 0) maxHeap.offer(freq);
        
        // Initialise queue ... [taskFreq, reuseTime]
        Queue<int[]> queue = new LinkedList<>();


        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            // Task becomes available
            if (!queue.isEmpty() && queue.peek()[1] == totalTime) maxHeap.offer(queue.poll()[0]);
            
            if (!maxHeap.isEmpty()) {
                int currentTask = maxHeap.poll();
                // Only enqueue if task not yet depleted
                if (currentTask > 1) queue.offer(new int[] {currentTask-1, totalTime+n+1});
            }
            totalTime++;
        }
        return totalTime;
    }
}
