class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()+1][p.length()+1];
        return match(cache, s, p, 0, 0);
    }


    private boolean match(Boolean[][] cache, String s, String p, int i, int j) {
        
        // Return cached result
        if (cache[i][j] != null) return cache[i][j];

        // Pattern is exhausted
        if (j >= p.length()) return (i >= s.length());

        // Check if current characters match
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result;

        if (j < p.length()-1 && p.charAt(j+1) == '*') {
            result = match(cache, s, p, i, j+2) || (firstMatch && match(cache, s, p, i+1, j));
        } else {
            result = firstMatch && match(cache, s, p, i+1, j+1);
        }
        
        // Memoize
        cache[i][j] = result;
        return result;        
    }
}
