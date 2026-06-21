import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // shrink window until valid
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}