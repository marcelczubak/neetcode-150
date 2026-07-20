class Solution {
    public String longestPalindrome(String s) {

        if (s.length() == 1) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int left = i-1, right = i + 1;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                int length = right - left + 1;

                // Update substring if longer
                if (length > (end - start + 1)) {
                    start = left;
                    end = right;
                }

                // Move pointers apart
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                int length = right - left + 1;
                
                // Update substring if longer
                if (length > (end - start + 1)) {
                    start = left;
                    end = right;
                };

                // Move pointers apart
                left--;
                right++;
            }
        }
        return s.substring(start, end+1);
    }
}
