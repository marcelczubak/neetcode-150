import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {

        // <row,col  -->  numPaths>
        Map<String, Integer> cache = new HashMap<>();
        
        int paths = 0;
        paths += dfs(cache, m, n, 0, 0);

        return paths;

    }


    private int dfs(Map<String, Integer> cache, int m, int n, int row, int col) {

        String key = stringify(row, col);
        if (cache.containsKey(key)) return cache.get(key);
        
        if (row == m-1 || col == n-1) return 1;
        if (row > m-1 || col > n-1) return 0;

        int right = dfs(cache, m, n, row+1, col);
        int down = dfs(cache, m, n, row, col+1);

        int paths = right + down;
        cache.put(key, paths);

        return paths;
    }

    private String stringify(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }

}
