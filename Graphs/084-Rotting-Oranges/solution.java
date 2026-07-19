import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        // Store rotten oranges in this queue
        Queue<int[]> queue = new LinkedList<>();

        // Traverse grid
        // Add all rotten oranges to the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        // Minutes since rotting
        int minutes = 0;

        // Run BFS
        while (!queue.isEmpty()) {

            int n = queue.size();

            // Processes all n oranges in a given minute in the queue
            for (int i = 0; i < n; i++) {
                // Process rotten oranges [i, j]
                int[] orange = queue.remove();
                int row = orange[0];
                int col = orange[1];

                processOranges(queue, grid, row+1, col);
                processOranges(queue, grid, row, col+1);
                processOranges(queue, grid, row-1, col);
                processOranges(queue, grid, row, col-1);
            }
            if(!queue.isEmpty()) minutes++;
        }

        // Traverse grid
        // Ensure no more fresh oranges exist
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return minutes;
    }

    private void processOranges(Queue<int[]> queue, int[][] grid, int row, int col) {

        // Base case
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        // Add to queue and ROT
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            queue.offer(new int[]{row, col});
        }
    }

}
