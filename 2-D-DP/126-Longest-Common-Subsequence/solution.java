class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // [i][j] -> lcs(i, j)
        Integer[][] cache = new Integer[text1.length()][text2.length()];

        return lcs(cache, text1, text2, 0, 0);
    }

    private int lcs(Integer[][] cache, String text1, String text2, int i, int j) {
        
        // Pointer reached end of any string
        if (i == text1.length() || j == text2.length()) return 0;

        // If memoised...
        if (cache[i][j] != null) return cache[i][j];

        int result = 0;

        // Characters match
        if (text1.charAt(i) == text2.charAt(j)) result = 1 + lcs(cache, text1, text2, i+1, j+1);
        // Characters don't match
        else result = Math.max(lcs(cache, text1, text2, i+1, j), lcs(cache, text1, text2, i, j+1));

        // Memoise
        cache[i][j] = result;

        return result;
    }
}
