import java.util.*;

class KthLargest {

    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) pq.poll();
        }
    }
        
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        
        // Return kth largest (smallest of the k largest elements)
        return pq.peek();
    }
}
