import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freqCount = new int[26];
        int[] windowFreq = new int[26];

        for (char c : s1.toCharArray()) {
            freqCount[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length();

        while (right < s2.length()) {

            if (Arrays.equals(freqCount, windowFreq)) {
                return true;
            }

            windowFreq[s2.charAt(left) - 'a']--;
            left++;

            windowFreq[s2.charAt(right) - 'a']++;
            right++;
        }

        return Arrays.equals(freqCount, windowFreq);
    }
}