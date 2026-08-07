class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] cache = new Boolean[s1.length()+1][s2.length()+1];

        return interleave(cache, s1, s2, s3, 0, 0);
    }

    private boolean interleave(Boolean[][] cache, String s1, String s2, String s3, int i, int j) {

        if (cache[i][j] != null) return cache[i][j];

        if (i + j == s3.length()) return true;

        boolean s1match = i < s1.length() && s1.charAt(i) == s3.charAt(i+j);
        boolean s2match = j < s2.length() && s2.charAt(j) == s3.charAt(i+j);

        // Neither matches
        if (!(s1match || s2match)) return false;

        boolean res;

        // Both match
        if (s1match && s2match) {
            res = interleave(cache, s1, s2, s3, i+1, j) || interleave(cache, s1, s2, s3, i, j+1);
        } else if (s1match) {
            // Only s1 matches
            res = interleave(cache, s1, s2, s3, i+1, j);
        } else {
            // Only s2 matches
            res = interleave(cache, s1, s2, s3, i, j+1);
        }
        cache[i][j] = res;
        return res;
    }

}
