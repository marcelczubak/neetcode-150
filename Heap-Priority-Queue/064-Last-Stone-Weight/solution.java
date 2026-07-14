import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max PQ declaration
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to PQ
        for (int stone : stones) pq.add(stone);

        // Smash stones together while possible
        while (pq.size() >= 2) {

            int stoneA = pq.remove();
            int stoneB = pq.remove();

            if (stoneA > stoneB) pq.add(stoneA - stoneB);
        }

        return (pq.size() == 0) ? 0 : pq.peek();
    }
}