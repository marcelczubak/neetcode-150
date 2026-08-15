import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Create adjacency list
        // Node  -->  {neighbor, time}
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());

            int[] node = new int[2];
            node[0] = time[1]; // neighbor
            node[1] = time[2]; // time

            graph.get(time[0]).add(node);
        }


        // Repeatedly process node with shortest distance    ...  {distance, node}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        // Maintain shortest distances from source node
        int[] dist = new int[n+1];

        // Initialise all nodes with max possible distance
        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;

        // Initialise starting node with zero distance
        dist[k] = 0;

        // Add first node to PQ
        minHeap.offer(new int[]{0, k});


        // Main Dijkstra loop
        while (!minHeap.isEmpty()) {

            // Take node with smallest distance
            int[] minNode = minHeap.poll();
            if (minNode[0] > dist[minNode[1]]) continue;

            // Iterate through all of this nodes neighbors
            List<int[]> neighbors = graph.getOrDefault(minNode[1], new ArrayList<>());

            for (int[] neighbor : neighbors) {

                int v = neighbor[0];
                int time = neighbor[1];

                // Calculate the distance to reach this neighbor node
                int newDist = time + minNode[0];

                if (newDist < dist[neighbor[0]]) {
                    dist[v] = newDist;
                    minHeap.offer(new int[]{newDist, v});
                }
            }
        }

        // Return minimum time to access all nodes
        int minTime = -1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, dist[i]);
        }
        
        return minTime;
    }
}
