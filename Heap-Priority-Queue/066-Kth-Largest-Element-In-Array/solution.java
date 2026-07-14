import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // Initialise min heap PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all numbers to PQ and repetitively trim to maintain only k elements
        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) pq.poll();
        }

        // Return k-th largest (min of the largest k elements)
        return pq.peek();
    }
}
