import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        // Store last occurences (indices) of characters
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track current partition
        int start = 0; 
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Update furthest boundary
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // Partition complete (all characters included)
            if (i == end) {
                result.add(end - start + 1);
                start = end+1;
            }
        }

        return result;
    }
}
