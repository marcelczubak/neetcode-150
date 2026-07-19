import java.util.*;

class Solution {
    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // Pacific: top row
        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific, 0);
        }

        // Pacific: left column
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific, 0);
        }

        // Atlantic: bottom row
        for (int c = 0; c < COLS; c++) {
            dfs(heights, ROWS - 1, c, atlantic, 0);
        }

        // Atlantic: right column
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, COLS - 1, atlantic, 0);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        dfs(heights, r+1, c, visited, heights[r][c]);
        dfs(heights, r-1, c, visited, heights[r][c]);
        dfs(heights, r, c+1, visited, heights[r][c]);
        dfs(heights, r, c-1, visited, heights[r][c]);
    }
}