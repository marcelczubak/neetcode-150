class Solution {
    public int minDistance(String word1, String word2) {

        Integer[][] cache = new Integer[word1.length()+1][word2.length()+1];

        return getMinDist(cache, word1, word2, 0, 0);
    }

    private int getMinDist(Integer[][] cache, String word1, String word2, int i, int j) {

        if (i >= word1.length()) return word2.length() - j;
        if (j >= word2.length()) return word1.length() - i;

        if (cache[i][j] != null) return cache[i][j];

        if (word1.charAt(i) == word2.charAt(j)) return getMinDist(cache, word1, word2, i+1, j+1);

        int insert, delete, replace, result;

        insert = getMinDist(cache, word1, word2, i, j+1);
        delete = getMinDist(cache, word1, word2, i+1, j);
        replace = getMinDist(cache, word1, word2, i+1, j+1);
        
        if (insert < delete) result = 1+ Math.min(insert, replace);
        else result = 1+ Math.min(delete, replace);

        cache[i][j] = result;
        return result;
    }

}
