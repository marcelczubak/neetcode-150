import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        
        // Substring frequency requirements
        Map<Character, Integer> freqTarget = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqTarget.put(c, freqTarget.getOrDefault(c, 0) + 1);
        }

        // Build window
        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        // Idea: 
        // expand until vaid
        // shrink while valid

        int need = freqTarget.size();
        int have = 0;

        Map<Character, Integer> freqCurrent = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            // add char to window
            char thisChar = s.charAt(right);
            freqCurrent.put(thisChar, freqCurrent.getOrDefault(thisChar, 0) + 1);

            if (freqTarget.containsKey(thisChar) && 
                freqCurrent.get(thisChar).equals(freqTarget.get(thisChar))) {
                have++;
            }
                

            while (have == need) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char toRemove = s.charAt(left);

                if (freqTarget.containsKey(toRemove) &&
                    freqCurrent.get(toRemove).equals(freqTarget.get(toRemove))) {
                    have--;
                }

                freqCurrent.put(
                    toRemove,
                    freqCurrent.get(toRemove) - 1
                );

                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex+minLength);
    }
}
