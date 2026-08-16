import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // {maxPathHeight, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        while (!minHeap.isEmpty()) {

            int[] current = minHeap.poll();
            int maxPathHeight = current[0], row = current[1], col = current[2];

            if (row == grid.length-1 && col == grid[0].length-1) return maxPathHeight;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] dir : directions) {

                int newRow = row+dir[0];
                int newCol = col+dir[1];

                // if neighbor is valid and unvisited...
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && !visited[newRow][newCol]) {

                    int newPathMax = Math.max(maxPathHeight, grid[newRow][newCol]);

                    minHeap.offer(new int[]{newPathMax, newRow, newCol});

                }
            }
        }
        return -1;
    }
}
