class Solution {
    public int minCostConnectPoints(int[][] points) {

        int result = 0;
        int n = points.length;

        // Tracks whether a point is already in the MST
        boolean[] visited = new boolean[n]; 

        // Tracks the cheapest edge known that connects point i to any point already in MST
        int[] minCost = new int[n];
        for (int i = 1; i < n; i++) minCost[i] = Integer.MAX_VALUE;


        for (int point = 0; point < n; point++) {

            int cheapestCost = Integer.MAX_VALUE;
            int cheapestPoint = -1;

            // Find cheapest unvisited point
            for (int i = 0; i < visited.length; i++) {

                if (!visited[i] && minCost[i] < cheapestCost) {
                    cheapestPoint = i;
                    cheapestCost = minCost[i];
                }
            }

            // Add point to MST
            result += cheapestCost;
            visited[cheapestPoint] = true;

            // Update minCost for remaining points
            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    // Calculate Manhattan distance
                    int distance = Math.abs(points[cheapestPoint][0] - points[i][0]) + Math.abs(points[cheapestPoint][1] - points[i][1]);

                    minCost[i] = Math.min(minCost[i], distance);
                }
            }
        }
    
        return result;
    }
}