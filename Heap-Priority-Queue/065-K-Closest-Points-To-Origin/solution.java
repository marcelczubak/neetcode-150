import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max heap: largest distance is at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] point : points) {

            int distance = point[0] * point[0] + point[1] * point[1];

            // [distance, x, y]
            pq.offer(new int[] { distance, point[0], point[1] });

            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {

            int[] point = pq.poll();

            result[i][0] = point[1];
            result[i][1] = point[2];

            i++;
        }
        return result;
    }
}