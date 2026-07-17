class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;

        // Traverse all cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    // Potentially update the maximum area
                    int area = getArea(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }

            }
        }
        return maxArea;
    }

    private int getArea(int i, int j, int[][] grid) {
        
        // Base case
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        // Visit cell
        grid[i][j] = 0;

        // Visit surroundings and add current cell to this area
        return 1 + getArea(i+1,j,grid) + getArea(i-1,j,grid) + getArea(i,j+1,grid) + getArea(i,j-1,grid);

    }
}