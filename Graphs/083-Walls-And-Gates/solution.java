import java.util.*;

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // ** O(M*N)
        // traverse grid
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // add all treasure coords to queue
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // current treasure chest
                int[] chest = queue.remove();

                int r = chest[0];
                int c = chest[1];

                grid[r][c] = distance;

                addLand(grid, r+1, c, visited, queue);
                addLand(grid, r-1, c, visited, queue);
                addLand(grid, r, c+1, visited, queue);
                addLand(grid, r, c-1, visited, queue);
            }
            distance++;
        }
    }

    private void addLand(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || visited[row][col] || grid[row][col] == -1) return;

        visited[row][col] = true;
        queue.add(new int[]{row,col});
    }
    
}
