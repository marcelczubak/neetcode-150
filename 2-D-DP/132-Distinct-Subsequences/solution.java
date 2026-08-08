class Solution {
    public int numDistinct(String s, String t) {

        Integer[][] cache = new Integer[s.length()+1][t.length()+1];

        return distinctPaths(cache, s, t, 0, 0);
    }

    private int distinctPaths(Integer[][] cache, String s, String t, int i, int j) {

        if (cache[i][j] != null) return cache[i][j];

        if (j >= t.length()) return 1;
        if (i >= s.length()) return 0;

        int paths = 0;

        int tryNext = distinctPaths(cache, s, t, i+1, j);
        int useThis = distinctPaths(cache, s, t, i+1, j+1);

        if (s.charAt(i) == t.charAt(j)) paths += tryNext + useThis;
        else paths += tryNext;
        
        cache[i][j] = paths;
        return paths;
    }
}
