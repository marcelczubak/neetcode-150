class Solution {
    public int countSubstrings(String s) {
        
        int substrings = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length substrings (same index)
            substrings += expand(s, i, i);
            // Even length substrings (adjacent indices)
            substrings += expand(s, i, i + 1);
        }
        return substrings;
    }

    // Returns the number of palindromes from index
    private int expand(String s, int left, int right) {
        int count = 0;

        while (
            left >= 0 &&
            right < s.length() &&
            s.charAt(left) == s.charAt(right)
        ) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
