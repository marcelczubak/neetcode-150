class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int result = 0, m = matrix.length, n = matrix[0].length;
        Integer[][] cache = new Integer[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(cache, matrix, i, j));
            }
        }

        return result;
    }

    private int dfs(Integer[][] cache, int[][] matrix, int row, int col) {

        if (cache[row][col] != null) return cache[row][col];
        
        int cell = matrix[row][col];
        int up, down, left, right, result;

        up = (row > 0 && matrix[row-1][col] > cell) ? dfs(cache, matrix, row-1, col) : 0;
        down = (row < matrix.length-1 && matrix[row+1][col] > cell) ? dfs(cache, matrix, row+1, col) : 0;
        left = (col > 0 && matrix[row][col-1] > cell) ? dfs(cache, matrix, row, col-1) : 0;
        right = (col < matrix[0].length-1 && matrix[row][col+1] > cell) ? dfs(cache, matrix, row, col+1) : 0;

        result = 1 + Math.max(up, Math.max(down, Math.max(left, right)));

        cache[row][col] = result;
        return result;
    }
}
