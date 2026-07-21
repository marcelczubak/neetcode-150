import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Map<Integer, Boolean> memo = new HashMap<>();

        // Recurse with current index
        return checkSubstring(memo, wordDict, s, 0);
        
    }

    private boolean checkSubstring(Map<Integer, Boolean> memo, List<String> wordDict, String s, int index) {
        
        if (memo.containsKey(index)) return memo.get(index);

        // Base case : index exceeded string length
        if (index >= s.length()) return true;

        // For every word
        for (String word : wordDict) {
            // If this word matches
            if (match(word, s, index)) {
                // If the recursion finsihes true ... IMMEDIATELY return true
                if (checkSubstring(memo, wordDict, s, index+word.length())) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false);
        // No match found
        return false;
    }

    private boolean match(String word, String s, int index) {
        if (index + word.length() > s.length()) return false;
        return (s.substring(index, index + word.length()).equals(word));
    }


}
